package dm550.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AppUI extends AppCompatActivity implements UserInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        final LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        TextView tv = new TextView(this);
        tv.setText("Please select the number of players!");
        layout.addView(tv);
        final NumberPicker np = new NumberPicker(this);
        np.setMinValue(2);
        np.setMaxValue(6);
        layout.addView(np);
        Button b = new AppCompatButton(this);
        b.setText("OK");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUI.this.startGame(new TTTGame(np.getValue()));
            }
        });
        layout.addView(b);
        TextView tv2 = new TextView(this);
        tv2.setText("Or play against an AI");
        layout.addView(tv2);
        Button b2 = new AppCompatButton(this);
        b2.setText("AI starts");
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUI.this.startGame(new TTTGame(0));
            }
        });
        layout.addView(b2);
        Button b3 = new AppCompatButton(this);
        b3.setText("You start");
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUI.this.startGame(new TTTGame(1));
            }
        });
        layout.addView(b3);
        ScrollView2D sv = new ScrollView2D(this);
        sv.setContent(layout);
        this.setContentView(sv);
    }
    @Override
    public void startGame(final Game game) {
        if (game.numberOfPlayers() == 0) {
            game.setUserInterface(this);
            class PosButton extends AppCompatButton {
                private final Coordinate pos;

                public PosButton(Coordinate pos) {
                    super(AppUI.this);
                    this.pos = pos;
                }

                @Override
                public void onMeasure(int wSpec, int hSpec) {
                    super.onMeasure(wSpec, hSpec);
                    final int w = getMeasuredWidth();
                    setMeasuredDimension(w, w);
                }
            }
            final List<PosButton> buttons = new ArrayList<PosButton>();
            AppUI.this.setTitle(game.getTitle());
            TableLayout layout = new TableLayout(AppUI.this);
            final int xSize = game.getHorizontalSize();
            final int ySize = game.getVerticalSize();
            for (int i = 0; i < ySize; i++) {
                layout.setColumnStretchable(i, true);
            }
            for (int i = 0; i < ySize; i++) {
                TableRow row = new TableRow(AppUI.this);
                for (int j = 0; j < xSize; j++) {
                    Coordinate pos = new XYCoordinate(j, i);
                    if (j == 0 && i == 0) {
                        PosButton s = new PosButton(pos);
                        buttons.add(s);
                        s.setText("2");
                        row.addView(s);
                    }
                    else {
                        PosButton b = new PosButton(pos);
                        buttons.add(b);
                        b.setText(" ");
                        b.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Coordinate pos = ((PosButton) view).pos;
                                if (game.isFree(pos)) {
                                    game.addMove2(pos, 1);
                                    for (PosButton button : buttons) {
                                        button.setText(game.getContent(button.pos));
                                    }
                                }
                                game.checkResult();
                                if (!game.isFull()) {
                                    Coordinate pos2 = new TTTAI(game.getBoard());
                                    game.addMove2(pos2, 2);
                                    for (PosButton button : buttons) {
                                        button.setText(game.getContent(button.pos));
                                    }
                                }
                                game.checkResult();
                            }
                        });
                        row.addView(b);
                    }
                }
                layout.addView(row);
            }
            ScrollView2D sv = new ScrollView2D(this);
            sv.setContent(layout);
            setContentView(sv);
        }
        else if (game.numberOfPlayers() == 1) {
            game.setUserInterface(this);
            class PosButton extends AppCompatButton {
                private final Coordinate pos;

                public PosButton(Coordinate pos) {
                    super(AppUI.this);
                    this.pos = pos;
                }

                @Override
                public void onMeasure(int wSpec, int hSpec) {
                    super.onMeasure(wSpec, hSpec);
                    final int w = getMeasuredWidth();
                    setMeasuredDimension(w, w);
                }
            }
            final List<PosButton> buttons = new ArrayList<PosButton>();
            AppUI.this.setTitle(game.getTitle());
            TableLayout layout = new TableLayout(AppUI.this);
            final int xSize = game.getHorizontalSize();
            final int ySize = game.getVerticalSize();
            for (int i = 0; i < ySize; i++) {
                layout.setColumnStretchable(i, true);
            }
            for (int i = 0; i < ySize; i++) {
                TableRow row = new TableRow(AppUI.this);
                for (int j = 0; j < xSize; j++) {
                    Coordinate pos = new XYCoordinate(j, i);
                    PosButton b = new PosButton(pos);
                    buttons.add(b);
                    b.setText(" ");
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Coordinate pos = ((PosButton) view).pos;
                            if (game.isFree(pos)) {
                                game.addMove2(pos, 1);
                                for (PosButton button : buttons) {
                                    button.setText(game.getContent(button.pos));
                                }
                            }
                            game.checkResult();
                            if (!game.isFull()) {
                                Coordinate pos2 = new TTTAI(game.getBoard());
                                game.addMove2(pos2, 2);
                                for (PosButton button : buttons) {
                                    button.setText(game.getContent(button.pos));
                                }
                            }
                            game.checkResult();
                        }
                    });
                    row.addView(b);
                }
                layout.addView(row);
            }
            ScrollView2D sv = new ScrollView2D(this);
            sv.setContent(layout);
            setContentView(sv);
        }
        else{
            game.setUserInterface(this);
            class PosButton extends AppCompatButton {
                private final Coordinate pos;

                public PosButton(Coordinate pos) {
                    super(AppUI.this);
                    this.pos = pos;
                }

                @Override
                public void onMeasure(int wSpec, int hSpec) {
                    super.onMeasure(wSpec, hSpec);
                    final int w = getMeasuredWidth();
                    setMeasuredDimension(w, w);
                }
            }
            final List<PosButton> buttons = new ArrayList<PosButton>();
            AppUI.this.setTitle(game.getTitle());
            TableLayout layout = new TableLayout(AppUI.this);
            final int xSize = game.getHorizontalSize();
            final int ySize = game.getVerticalSize();
            for (int i = 0; i < ySize; i++) {
                layout.setColumnStretchable(i, true);
            }
            for (int i = 0; i < ySize; i++) {
                TableRow row = new TableRow(AppUI.this);
                for (int j = 0; j < xSize; j++) {
                    Coordinate pos = new XYCoordinate(j, i);
                    PosButton b = new PosButton(pos);
                    buttons.add(b);
                    b.setText(" ");
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Coordinate pos = ((PosButton) view).pos;
                            if (game.isFree(pos)) {
                                game.addMove(pos);
                                for (PosButton button : buttons) {
                                    button.setText(game.getContent(button.pos));
                                }
                            }
                            game.checkResult();
                        }
                    });
                    row.addView(b);
                }

                layout.addView(row);
            }
            ScrollView2D sv = new ScrollView2D(this);
            sv.setContent(layout);
            setContentView(sv);
        }
    }

    @Override
    public void showResult(final String message) {
        LinearLayout view = new LinearLayout(this);
        view.setOrientation(LinearLayout.VERTICAL);
        TextView tv = new TextView(this);
        tv.setText(message);
        view.addView(tv);
        Button b = new Button(this);
        b.setText("OK");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUI.this.onBackPressed();
            }
        });
        view.addView(b);
        this.setContentView(view);
    }

}
