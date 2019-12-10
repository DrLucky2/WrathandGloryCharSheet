package com.example.wrathandglorycharsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int points = 300;
    private int rank = 0;
    private int strength = 0;
    private int agility = 0;
    private int toughness = 0;
    private int intellect = 0;
    private int willpower = 0;
    private int fellowship = 0;
    private int initiative = 0;
    private int athletics = 0;
    private int awareness = 0;
    private int ballistic = 0;
    private int cunning = 0;
    private int deception = 0;
    private int insight = 0;
    private int intimidation = 0;
    private int investigation = 0;
    private int leadership = 0;
    private int medicae = 0;
    private int persuasion = 0;
    private int pilot = 0;
    private int psychic = 0;
    private int scholar = 0;
    private int stealth = 0;
    private int survival = 0;
    private int tech = 0;
    private int weapon = 0;
    private int soak = 0;
    private String a = "error 404 not found ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText weapt = findViewById(R.id.weat);
        final EditText atht = findViewById(R.id.athlecticst);
        final EditText awat = findViewById(R.id.awarnesst);
        final EditText ballt = findViewById(R.id.balt);
        final EditText cunt = findViewById(R.id.cunt);
        final EditText dect = findViewById(R.id.dect);
        final EditText inst = findViewById(R.id.inst);
        final EditText intt = findViewById(R.id.intt);
        final EditText invt = findViewById(R.id.invt);
        final EditText leat = findViewById(R.id.leat);
        final EditText medt = findViewById(R.id.medt);
        final EditText pert = findViewById(R.id.pert);
        final EditText pilt = findViewById(R.id.pilt);
        final EditText psyt = findViewById(R.id.psyt);
        final EditText scht = findViewById(R.id.scht);
        final EditText stet = findViewById(R.id.stet);
        final EditText surt = findViewById(R.id.surt);
        final EditText tect = findViewById(R.id.tect);
        final Button button = findViewById(R.id.button);
        //final EditText soakt = findViewById(R.id.tect);
        final EditText soakt = findViewById(R.id.editTexsdfsdt9s);
        final EditText speedt = findViewById(R.id.editText9s2);
        final EditText woundst = findViewById(R.id.editTextaaa9s);
        final EditText resilt = findViewById(R.id.editText9zzzs);
        final EditText defencet = findViewById(R.id.editText9s);
        final EditText shockt = findViewById(R.id.editTextaa9s);

        final EditText passivet = findViewById(R.id.editTexsda9s);
        final EditText convt = findViewById(R.id.editTextaaasdasda9s);
        final EditText resolvt = findViewById(R.id.eddasda9s);


        final EditText athleticsv = findViewById(R.id.athlectisn);

        final EditText pointsr = findViewById(R.id.editText4);
        final EditText pointst = findViewById(R.id.editText5);



        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent myIntent = new Intent(view.getContext(), agones.class);
                //startActivityForResult(myIntent, 0);


                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create(); //Read Update
                alertDialog.setTitle("D6 Roller");
                alertDialog.setMessage("Enter the number of six-sided dice you want to roll.");
                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                input.setRawInputType(Configuration.KEYBOARD_12KEY);
                alertDialog.setView(input);

                alertDialog.setButton("Roll Dice", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //final TextView textView = (TextView) findViewById(R.id.text);

                        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                        String url ="http://roll.diceapi.com/json/d6";

                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        //textView.setText("Response is: "+ response.substring(0,500));
                                        a = response.substring(0,500);
                                        pointst.setText(a);
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //textView.setText("That didn't work!");
                                a = "didnt work";
                            }
                        });
                        queue.add(stringRequest);


                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create(); //Read Update
                        alertDialog.setTitle("Die Results");
                        alertDialog.setMessage("Results " + a);

                        alertDialog.setButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });

                        alertDialog.show();
                    }
                });

                alertDialog.show();
            }

        });



        pointst.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                points = Integer.parseInt(pointst.getText().toString());
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        athleticsv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                athletics = Integer.parseInt(athleticsv.getText().toString());
                atht.setText(Integer.toString(athletics + strength));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText awarenessv = findViewById(R.id.awarenessn);
        awarenessv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                awareness = Integer.parseInt(awarenessv.getText().toString());
                awat.setText(Integer.toString(awareness + intellect));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText ballisticv = findViewById(R.id.baln);
        ballisticv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ballistic = Integer.parseInt(ballisticv.getText().toString());
                ballt.setText(Integer.toString(agility + ballistic));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText cunningv = findViewById(R.id.cunn);
        cunningv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cunning = Integer.parseInt(cunningv.getText().toString());
                cunt.setText(Integer.toString(cunning + fellowship));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText deceptionv = findViewById(R.id.decn);
        deceptionv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                deception = Integer.parseInt(deceptionv.getText().toString());
                dect.setText(Integer.toString(deception + fellowship));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText insightv = findViewById(R.id.insn);
        insightv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                insight = Integer.parseInt(insightv.getText().toString());
                inst.setText(Integer.toString(insight + fellowship));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText intimifationv = findViewById(R.id.intn);
        intimifationv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                intimidation = Integer.parseInt(intimifationv.getText().toString());
                intt.setText(Integer.toString(intimidation + willpower));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText investv = findViewById(R.id.invn);
        investv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                investigation = Integer.parseInt(investv.getText().toString());
                invt.setText(Integer.toString(investigation + intellect));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText leaderv = findViewById(R.id.lean);
        leaderv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                leadership = Integer.parseInt(leaderv.getText().toString());
                leat.setText(Integer.toString(leadership + willpower));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText medv = findViewById(R.id.medn);
        medv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                medicae = Integer.parseInt(medv.getText().toString());
                medt.setText(Integer.toString(medicae + intellect));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText perv = findViewById(R.id.pern);
        perv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                persuasion = Integer.parseInt(perv.getText().toString());
                pert.setText(Integer.toString(persuasion + fellowship));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText pilv = findViewById(R.id.piln);
        pilv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pilot = Integer.parseInt(pilv.getText().toString());
                pilt.setText(Integer.toString(agility + pilot));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText psyv = findViewById(R.id.psyn);
        psyv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                psychic = Integer.parseInt(psyv.getText().toString());
                psyt.setText(Integer.toString(psychic + willpower));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText schv = findViewById(R.id.schn);
        schv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                scholar = Integer.parseInt(schv.getText().toString());
                scht.setText(Integer.toString(scholar + intellect));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText stev = findViewById(R.id.sten);
        stev.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stealth = Integer.parseInt(stev.getText().toString());
                stet.setText(Integer.toString(agility+ stealth));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText surv = findViewById(R.id.surn);
        surv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                survival = Integer.parseInt(surv.getText().toString());
                surt.setText(Integer.toString(willpower + survival));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText tecv = findViewById(R.id.tecn);
        tecv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tech = Integer.parseInt(tecv.getText().toString());
                tect.setText(Integer.toString(tech + intellect));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText weapv = findViewById(R.id.wean);
        weapv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                weapon = Integer.parseInt(weapv.getText().toString());
                weapt.setText(Integer.toString(initiative + weapon));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText rankv = findViewById(R.id.edifgtText);
        rankv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                rank = Integer.parseInt(rankv.getText().toString());
                woundst.setText(Integer.toString(toughness + rank));
                shockt.setText(Integer.toString(willpower + rank));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText strengthv = findViewById(R.id.editText8);
        strengthv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strength = Integer.parseInt(strengthv.getText().toString());
                atht.setText(Integer.toString(athletics + strength));
                awat.setText(Integer.toString(awareness + intellect));
                ballt.setText(Integer.toString(agility + ballistic));
                cunt.setText(Integer.toString(cunning + fellowship));
                dect.setText(Integer.toString(deception + fellowship));
                inst.setText(Integer.toString(insight + fellowship));
                intt.setText(Integer.toString(intimidation + willpower));
                invt.setText(Integer.toString(investigation + intellect));
                leat.setText(Integer.toString(leadership + willpower));
                medt.setText(Integer.toString(medicae + intellect));
                pert.setText(Integer.toString(persuasion + fellowship));
                pilt.setText(Integer.toString(agility + pilot));
                psyt.setText(Integer.toString(psychic + willpower));
                scht.setText(Integer.toString(scholar + intellect));
                stet.setText(Integer.toString(agility+ stealth));
                surt.setText(Integer.toString(willpower + survival));
                tect.setText(Integer.toString(tech + intellect));
                weapt.setText(Integer.toString(initiative + weapon));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText agilityv = findViewById(R.id.editText8wer);
        agilityv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                agility = Integer.parseInt(agilityv.getText().toString());
                speedt.setText(Integer.toString(agility));
                atht.setText(Integer.toString(athletics + strength));
                awat.setText(Integer.toString(awareness + intellect));
                ballt.setText(Integer.toString(agility + ballistic));
                cunt.setText(Integer.toString(cunning + fellowship));
                dect.setText(Integer.toString(deception + fellowship));
                inst.setText(Integer.toString(insight + fellowship));
                intt.setText(Integer.toString(intimidation + willpower));
                invt.setText(Integer.toString(investigation + intellect));
                leat.setText(Integer.toString(leadership + willpower));
                medt.setText(Integer.toString(medicae + intellect));
                pert.setText(Integer.toString(persuasion + fellowship));
                pilt.setText(Integer.toString(agility + pilot));
                psyt.setText(Integer.toString(psychic + willpower));
                scht.setText(Integer.toString(scholar + intellect));
                stet.setText(Integer.toString(agility+ stealth));
                surt.setText(Integer.toString(willpower + survival));
                tect.setText(Integer.toString(tech + intellect));
                weapt.setText(Integer.toString(initiative + weapon));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));

            }
        });

        final EditText toughnessv = findViewById(R.id.editTexwert8);
        toughnessv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                toughness = Integer.parseInt(toughnessv.getText().toString());
                woundst.setText(Integer.toString(toughness + rank));
                resilt.setText(Integer.toString(toughness + 1));
                atht.setText(Integer.toString(athletics + strength));
                awat.setText(Integer.toString(awareness + intellect));
                ballt.setText(Integer.toString(agility + ballistic));
                cunt.setText(Integer.toString(cunning + fellowship));
                dect.setText(Integer.toString(deception + fellowship));
                inst.setText(Integer.toString(insight + fellowship));
                intt.setText(Integer.toString(intimidation + willpower));
                invt.setText(Integer.toString(investigation + intellect));
                leat.setText(Integer.toString(leadership + willpower));
                medt.setText(Integer.toString(medicae + intellect));
                pert.setText(Integer.toString(persuasion + fellowship));
                pilt.setText(Integer.toString(agility + pilot));
                psyt.setText(Integer.toString(psychic + willpower));
                scht.setText(Integer.toString(scholar + intellect));
                stet.setText(Integer.toString(agility+ stealth));
                surt.setText(Integer.toString(willpower + survival));
                tect.setText(Integer.toString(tech + intellect));
                weapt.setText(Integer.toString(initiative + weapon));

                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText intellectv = findViewById(R.id.editTexter8);
        intellectv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                intellect = Integer.parseInt(intellectv.getText().toString());
                passivet.setText(Integer.toString(intellect + 1));
                atht.setText(Integer.toString(athletics + strength));
                awat.setText(Integer.toString(awareness + intellect));
                ballt.setText(Integer.toString(agility + ballistic));
                cunt.setText(Integer.toString(cunning + fellowship));
                dect.setText(Integer.toString(deception + fellowship));
                inst.setText(Integer.toString(insight + fellowship));
                intt.setText(Integer.toString(intimidation + willpower));
                invt.setText(Integer.toString(investigation + intellect));
                leat.setText(Integer.toString(leadership + willpower));
                medt.setText(Integer.toString(medicae + intellect));
                pert.setText(Integer.toString(persuasion + fellowship));
                pilt.setText(Integer.toString(agility + pilot));
                psyt.setText(Integer.toString(psychic + willpower));
                scht.setText(Integer.toString(scholar + intellect));
                stet.setText(Integer.toString(agility+ stealth));
                surt.setText(Integer.toString(willpower + survival));
                tect.setText(Integer.toString(tech + intellect));
                weapt.setText(Integer.toString(initiative + weapon));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText willpowerv = findViewById(R.id.editTexts8);
        willpowerv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                willpower = Integer.parseInt(willpowerv.getText().toString());
                soakt.setText(Integer.toString(willpower));
                shockt.setText(Integer.toString(willpower + rank));
                convt.setText(Integer.toString(willpower));
                resolvt.setText(Integer.toString(willpower + 1));
                atht.setText(Integer.toString(athletics + strength));
                awat.setText(Integer.toString(awareness + intellect));
                ballt.setText(Integer.toString(agility + ballistic));
                cunt.setText(Integer.toString(cunning + fellowship));
                dect.setText(Integer.toString(deception + fellowship));
                inst.setText(Integer.toString(insight + fellowship));
                intt.setText(Integer.toString(intimidation + willpower));
                invt.setText(Integer.toString(investigation + intellect));
                leat.setText(Integer.toString(leadership + willpower));
                medt.setText(Integer.toString(medicae + intellect));
                pert.setText(Integer.toString(persuasion + fellowship));
                pilt.setText(Integer.toString(agility + pilot));
                psyt.setText(Integer.toString(psychic + willpower));
                scht.setText(Integer.toString(scholar + intellect));
                stet.setText(Integer.toString(agility+ stealth));
                surt.setText(Integer.toString(willpower + survival));
                tect.setText(Integer.toString(tech + intellect));
                weapt.setText(Integer.toString(initiative + weapon));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText fellowshipv = findViewById(R.id.editText8as);
        fellowshipv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fellowship = Integer.parseInt(fellowshipv.getText().toString());
                atht.setText(Integer.toString(athletics + strength));
                awat.setText(Integer.toString(awareness + intellect));
                ballt.setText(Integer.toString(agility + ballistic));
                cunt.setText(Integer.toString(cunning + fellowship));
                dect.setText(Integer.toString(deception + fellowship));
                inst.setText(Integer.toString(insight + fellowship));
                intt.setText(Integer.toString(intimidation + willpower));
                invt.setText(Integer.toString(investigation + intellect));
                leat.setText(Integer.toString(leadership + willpower));
                medt.setText(Integer.toString(medicae + intellect));
                pert.setText(Integer.toString(persuasion + fellowship));
                pilt.setText(Integer.toString(agility + pilot));
                psyt.setText(Integer.toString(psychic + willpower));
                scht.setText(Integer.toString(scholar + intellect));
                stet.setText(Integer.toString(agility+ stealth));
                surt.setText(Integer.toString(willpower + survival));
                tect.setText(Integer.toString(tech + intellect));
                weapt.setText(Integer.toString(initiative + weapon));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });

        final EditText inititivev = findViewById(R.id.editText8s);
        inititivev.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                initiative = Integer.parseInt(inititivev.getText().toString());
                weapt.setText(Integer.toString(initiative + weapon));
                defencet.setText(Integer.toString(initiative - 1));
                atht.setText(Integer.toString(athletics + strength));
                awat.setText(Integer.toString(awareness + intellect));
                ballt.setText(Integer.toString(agility + ballistic));
                cunt.setText(Integer.toString(cunning + fellowship));
                dect.setText(Integer.toString(deception + fellowship));
                inst.setText(Integer.toString(insight + fellowship));
                intt.setText(Integer.toString(intimidation + willpower));
                invt.setText(Integer.toString(investigation + intellect));
                leat.setText(Integer.toString(leadership + willpower));
                medt.setText(Integer.toString(medicae + intellect));
                pert.setText(Integer.toString(persuasion + fellowship));
                pilt.setText(Integer.toString(agility + pilot));
                psyt.setText(Integer.toString(psychic + willpower));
                scht.setText(Integer.toString(scholar + intellect));
                stet.setText(Integer.toString(agility+ stealth));
                surt.setText(Integer.toString(willpower + survival));
                tect.setText(Integer.toString(tech + intellect));
                weapt.setText(Integer.toString(initiative + weapon));
                pointsr.setText(Integer.toString(points - (strength + agility + toughness + intellect + willpower
                        + fellowship + initiative + athletics + awareness + ballistic + cunning + deception + insight
                        + intimidation + investigation + leadership + medicae + persuasion + pilot + psychic + scholar
                        + stealth + tech + weapon)));
            }
        });


        /*
        final EditText soakv = findViewById(R.id.editTexsdfsdt9s);
        soakv.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                willpower = Integer.parseInt(soakv.getText().toString());
                soakt.setText(Integer.toString(willpower));
            }
        });
        */


        /*	onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter)*/

    }
    /*
    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.roll_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    */

}
