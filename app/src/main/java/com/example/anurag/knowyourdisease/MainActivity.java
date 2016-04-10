package com.example.anurag.knowyourdisease;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private  final String LOG_TAG = MainActivity.class.getSimpleName();
    private Spinner spinner;
    private EditText text_name;
    private EditText text_age;
    private EditText text_weight;
    private EditText text_height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        Button button = (Button) findViewById(R.id.button);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              spinner = (Spinner) findViewById(R.id.spinner1);
              String spinner_text = spinner.getSelectedItem().toString();
              Log.d(LOG_TAG, spinner_text);
              //Toast.makeText(MainActivity.this, spinner_text, Toast.LENGTH_SHORT).show();
              text_name = (EditText) findViewById(R.id.name);
              final String name = text_name.getText().toString();
              Log.d(LOG_TAG, name);

              text_age = (EditText) findViewById(R.id.age);
              final String age = text_age.getText().toString();
              Log.d(LOG_TAG, age);

              text_height = (EditText) findViewById(R.id.height);
              final String height = text_height.getText().toString();
              Log.d(LOG_TAG, height);

              text_weight = (EditText) findViewById(R.id.weight);
              final String weight = text_weight.getText().toString();
              Log.d(LOG_TAG, weight);

              int wt = Integer.parseInt(weight);
              Log.d(LOG_TAG, "Weight is " + wt);
              double ht = Integer.parseInt(height);
              ht = ht/100.0;
              Log.d(LOG_TAG, "Height is " + ht);
              double bmi = wt/(ht*ht);
              Log.d(LOG_TAG, "BMI is " + bmi);
              DetailItem item;
              item = new DetailItem();

              item.setName(name);
              item.setAge(age);
              item.setHeight(height);
              item.setWeight(weight);
              item.setBmi(bmi);
              item.setDisease(spinner_text);

              String disesase_user = spinner_text.toLowerCase();
              Toast.makeText(MainActivity.this, name+age+height+weight+spinner_text+bmi+ item.getBmi().toString(),
              Toast.LENGTH_LONG).show();

              String[] diseases_name = {
                      "asthama",
                      "cholera",
                      "diabetes",
                      "diarrhea",
                      "jaundice",
                      "malaria",
                      "swine flu",
                      "viral fever"
              };
              int index = 0;
              for( int i= 0; i< diseases_name.length; i++) {
                  if(disesase_user.equalsIgnoreCase(diseases_name[i])) {
                      index = i;
                  }
              }
              Log.d(LOG_TAG, "Index is " + index);

              String[] causes = {
                      "The cause of asthma is poorly understood, " +
                              "but it may be partly inherited. " +
                              "Everyone's lungs are sensitive " +
                              "to different things such as pollen, " +
                              "air pollution, or strong chemicals. " +
                              "In simple terms, people with asthma " +
                              "have lungs that are more sensitive than " +
                              "average.",

                      "Common sources include:\n" +
                              "Municipal water supplies\n" +
                              "Ice made from municipal water\n" +
                              "Foods and drinks sold by street vendors\n" +
                              "Vegetables grown with water containing human wastes\n" +
                              "Raw or undercooked fish and seafood caught in waters polluted with sewage\n" +
                              "When a person consumes the contaminated food or water, the bacteria release a toxin " +
                              "in the intestines that produces severe diarrhea",

                      "Causes\n" +
                              "Insulin is a hormone produced by the pancreas to control blood sugar. " +
                              "Diabetes can be caused by too little insulin, resistance to insulin, or both.\n" +
                              "To understand diabetes, it is important to first understand the normal process " +
                              "by which food is broken down and used by the body for energy. Several things " +
                              "happen when food is digested:\n" + "A sugar called glucose enters the bloodstream." +
                              " Glucose is a source of fuel for the body.\n" + "An organ called the pancreas " +
                              "makes insulin. The role of insulin is to move glucose from the bloodstream into" +
                              " muscle, fat, and liver cells, where it can be stored or used as fuel.",

                      "Diarrhea : Caused by a viral infection, according to the ACG. The most common diarrhea-causing " +
                              "virus for adults is norovirus, which is often referred to as \"cruise ship " +
                              "diarrhea\" due to its unfortunate tendency to infect sea-faring vacationers. " +
                              "Rotavirus, another diarrhea-inducing virus, is very common in young children.\n" +
                              "\n" + "Other causes of acute diarrhea include bacterial infection, which is often" +
                              " referred to as \"traveler's diarrhea,\" or, in some parts of the world, \"Montezuma's " +
                              "revenge.\" But those who come down with this uncomfortable ailment aren't the " +
                              "victims of an ancient curse; they're usually the victims of the bacteria " +
                              "enterotoxigenic Escherichia coli",

                      "Jaundice : Old red blood cells travel to your liver, where they're broken down. " +
                              "Bilirubin is the yellow pigment formed by the breakdown of these old cells. " +
                              "Jaundice occurs when your liver doesn't metabolize bilirubin the way it's supposed to.",

                      "You can only get malaria if you're bitten by an infected mosquito, or if you receive " +
                              "infected blood from someone during a blood transfusion. Malaria can also be " +
                              "transmitted from mother to child during pregnancy.\n",

                      "Swine flu : The same way as the seasonal flu. When people who have it cough or " +
                              "sneeze, they spray tiny drops of the virus into the air. If you come in " +
                              "contact with these drops, touch a surface (like a doorknob or sink) where " +
                              "the drops landed, or touch something an infected person has recently touched, " +
                              "you can catch H1N1 swine flu.",

                      "Viral fever, as the name suggests, is a condition that is transmitted from one person to " +
                              "another through direct contact with the person’s bodily fluids. This is much " +
                              "simpler than you think. Here are some common causes of fever you didn’t know about." +
                              "\n" + "When a person coughs, sneezes, yawns or even talks they tend to spray " +
                              "tiny particles of fluid that contain bacteria and viruses from their body. If " +
                              "you are close enough, these bacteria enter your body through your nose or mouth " +
                              "and infect you. Once infected it takes anywhere from 16 hours to 48 hours to turn " +
                              "into a full blown infection.\n" + "You may also like to read about 8 things " +
                              "that weaken your immune system."
              };

              item.setCause(causes[index]);
              Log.d(LOG_TAG, "cause is " + item.getCause());

              String[] symptoms_diesease = {
                      "Some children feel an itch on the back of the neck just prior to an asthma attack. " +
                              "Some people have some warning sign that they can learn to recognize. Warning " +
                              "signs include sore throat, dark circles under the eyes, feeling tired or " +
                              "irritable, or a change in the colour of your face.\n" + "\n" +
                              "Asthma varies in its severity. Some people experience asthma symptoms " +
                              "continuously, while others experience symptoms only if exposed to triggers. " +
                              "Regardless of the severity, typical asthma symptoms include:\n" + "\n" +
                              "chest tightness\n" + "coughing\n" + "shortness of breath\n" + "wheezing\n" +
                              "With more severe asthma, these symptoms may occur at night.\n" + "\n" +
                              "Wheezing is the best-known asthma symptom, but not everyone with asthma wheezes. " +
                              "Some people only have a cough that doesn't seem to go away.",

                      "Symptoms of cholera can begin as soon as a few hours or as long as five days after " +
                              "infection. Often, symptoms are mild. But sometimes they are very serious. " +
                              "About one in 20 people infected have severe watery diarrhea accompanied by " +
                              "vomiting, which can quickly lead to dehydration. Although many infected " +
                              "people may have minimal or no symptoms, they can still contribute to " +
                              "spread of the infection.\n" + "\n" + "Signs and symptoms of dehydration include:\n" +
                              "\n" + "Rapid heart rate\n" + "Loss of skin elasticity (the ability to return " +
                              "to original position quickly if pinched)\n" + "Dry mucous membranes, including the " +
                              "inside of the mouth, throat, nose, and eyelids\n" + "Low blood pressure\n" +
                              "Thirst\n" + "Muscle cramps\n" + "If not treated, dehydration can lead to shock " +
                              "and death in a matter of hours.",

                      "A high blood sugar level can cause several symptoms, including:\n" +
                              "Blurry vision\n" +
                              "Excess thirst\n" +
                              "Fatigue\n" +
                              "Frequent urination\n" +
                              "Hunger\n" +
                              "Weight loss\n" +
                              "Because type 2 diabetes develops slowly, some people with high blood sugar have no symptoms.\n" +
                              "Symptoms of type 1 diabetes develop over a short period. People may be very sick by the time " +
                              "they are diagnosed.\n" + "After many years, diabetes can lead to other serious problems. " +
                              "These problems are known as diabetes complications, and include:\n" + "Eye problems, " +
                              "including trouble seeing (especially at night), light sensitivity, and blindness\n" + "Sores" +
                              " and infections of the leg or foot, which untreated can lead to amputation of the leg or foot\n" +
                              "Damage to nerves in the body, causing pain, tingling, a loss of feeling, problems digesting" +
                              " food, and erectile dysfunction\n" + "Kidney problems, which can lead to kidney failure\n" +
                              "Weakened immune system, which can lead to more frequent infections\n" +
                              "Increased chance of having a heart attack or stroke",

                      "Dark urine or small amounts of urine\n" +
                              "Rapid heart rate\n" +
                              "Dry, flushed skin\n" +
                              "Headaches or light-headedness\n" +
                              "Fatigue\n" +
                              "Irritability or confusion\n" +
                              "Severe abdominal or rectal pain\n" +
                              "Blood in the stool or black, tar-like stools",

                      "As well as the classic yellow tinge to the skin and whites of the eyes, someone with jaundice " +
                              "may also have yellowing of mucous membranes in the mouth and nose.\n" + "\n" +
                              "Stools (faeces or poo) can be pale in colour and urine dark in colour.\n" + "\n" +
                              "Some underlying conditions, which lead to jaundice, may feel like flu, and may also " +
                              "result in fever, chills, stomach pain, itching or weight-loss or be without an explanation " +
                              "such as a diet.",

                      "Symptoms usually appear about 12 to 14 days after infection. People with malaria have the " +
                              "following symptoms:\n" +
                              "\n" +
                              "abdominal pain\n" +
                              "chills and sweats\n" +
                              "diarrhea, nausea, and vomiting (these symptoms only appear sometimes)\n" +
                              "headache\n" +
                              "high fevers\n" +
                              "low blood pressure causing dizziness if moving from a lying or sitting " +
                              "position to a standing position (also called orthostatic hypotension)\n" +
                              "muscle aches\n" +
                              "poor appetite\n" +
                              "In people infected with P. falciparum, the following symptoms may also occur:\n" +
                              "\n" +
                              "anemia caused by the destruction of infected red blood cells\n" +
                              "extreme tiredness, delirium, unconsciousness, convulsions, and coma\n" +
                              "kidney failure\n" +
                              "pulmonary edema (a serious condition where fluid builds up in the lungs, " +
                              "which can lead to severe breathing problems)",

                      "These, too, are pretty much the same as seasonal flu. They can include:\n" +
                              "\n" +
                              "Cough\n" +
                              "Fever\n" +
                              "Sore throat\n" +
                              "Stuffy or runny nose\n" +
                              "Body aches\n" +
                              "Headache\n" +
                              "Chills\n" +
                              "Fatigue\n" +
                              "Like the regular flu, swine flu can lead to more serious problems including pneumonia, " +
                              "a lung infection, and other breathing problems. And it can make an illness like " +
                              "diabetes or asthma worse. If you have symptoms like shortness of breath, " +
                              "severe vomiting, pain in your belly or sides, dizziness, or confusion, " +
                              "call your doctor \n",

                      "Since the symptoms of viral fever often overlap other common and serious conditions it is" +
                              " pertinent to know about the symptoms that can help you differentiate between a" +
                              " viral fever and other diseases. The red flags you need to keep an eye out for " +
                              "are – very high fever that is either of the following:\n" +
                              "     Intermittent in nature (occurs at regular intervals)\n" +
                              "     Occurs along with chills\n" +
                              "     Doesn’t subside with medicines\n" +
                              "     Has been present for a long time\n" +
                              "Other symptoms are severe pain around the joints, vomiting, swelling of the " +
                              "face and a rash. If you experience any of these symptoms make it a point to visit " +
                              "your doctor immediately. Here are tips to keep common monsoon diseases at bay"
              };
              item.setSymptoms(symptoms_diesease[index]);
              Log.d(LOG_TAG, "Symptoms are :" + item.getSymptoms());

              String[] disease_cure = {
                      "Ask your doctor for a written \"asthma action plan.\" An asthma action plan describes " +
                            "how to monitor your asthma symptoms and take your asthma medications. It also " +
                            "explains how to tell if your asthma is getting worse and what to do if this happens.\n" +
                            "If recommended by your doctor, use \"preventer,” also called \"controller\" medications" +
                            " such as corticosteroids (e.g., beclomethasone*, budesonide, ciclesonide, fluticasone, " +
                            "or mometasone), with or without a long-acting bronchodilator (e.g., salmeterol, formoterol)," +
                            " leukotriene receptor antagonists (e.g., montelukast or zafirlukast), or IgE-neutralizing " +
                            "antibody (omalizumab).\n" + "Alleviate symptoms using \"reliever\" or \"rescue\" " +
                            "medications such as fast-acting bronchodilators ",

                      "Although there is a vaccine against cholera, the CDC and World Health Organization " +
                              "don't normally recommend it, because it may not protect up to half of the " +
                              "people who receive it and it lasts only a few months. However, you can " +
                              "protect yourself and your family by using only water that has been boiled, " +
                              "water that has been chemically disinfected, or bottled water. Be sure to " +
                              "use the bottled, boiled, or chemically disinfected water for the following purposes:\n" +
                              "\n" +
                              "Drinking\n" +
                              "Preparing food or drinks\n" +
                              "Making ice\n" +
                              "Brushing your teeth\n" +
                              "Washing your face and hands\n" +
                              "Washing dishes and utensils that you use to eat or prepare food\n" +
                              "Washing fruits and vegetables\n" +
                              "To disinfect your own water, boil it for one minute (or 3 minutes at higher elevations) or filter it and use a commercial chemical disinfectant. You should also avoid raw foods, including the following:\n" +
                              "\n" +
                              "Unpeeled fruits and vegetables\n" +
                              "Unpasteurized milk and milk products\n" +
                              "Raw or undercooked meat or shellfish\n" +
                              "Fish caught in tropical reefs, which may be contaminated",

                      "Type 2 diabetes may be reversed with lifestyle changes, especially losing weight " +
                              "with exercise and by eating healthier foods. Some cases of type 2 diabetes" +
                              " can also be improved with weight-loss surgery.\n" +
                              "There is no cure for type 1 diabetes.\n" +
                              "Treating either type 1 diabetes or type 2 diabetes involves medicines, " +
                              "diet, and exercise to control blood sugar level.\n" +
                              "Getting better control over your blood sugar, cholesterol, and blood pressure " +
                              "levels helps reduce the risk of kidney disease, eye disease, nervous system disease, " +
                              "heart attack, and stroke.\n" + "To prevent diabetes complications, visit your " +
                              "health care provider at least two to four times a year. Talk about any problems" +
                              " you are having. Follow your health care provider's instructions on managing your diabetes.",

                      "Most cases of diarrhea resolve spontaneously within a few days and all that is needed is preventing" +
                              " dehydration by replacing lost fluids, according to the NIH.\n" +
                              "\n" +
                              "In the meantime, various over-the-counter medications may help firm the stool " +
                              "and decrease the urgency for bowel movements. These include loperamide hydrochloride (commonly known as the brand name Imodium AD), bismuth subsalicylate (Pepto-Bismol) and attapulgite (Kaopectate). \n" +
                              "\n" +
                              "These medications, however, are not recommended for diarrhea caused by bacterial" +
                              " infection or parasites, according to the NIH, because organisms will be trapped " +
                              "in the intestines if the diarrhea ceases before they are completely excreted.\n" +
                              "\n" +
                              "The Cleveland Clinic recommends drinking two to three quarts or liters of liquids" +
                              " daily while recovering from diarrhea. While water is fine, it does not replace " +
                              "lost salt or nutrients, so better choices are broth, tea with honey, sports drinks and pulp-free juices. Avoid milk products, caffeine, alcohol, and apple and pear juices, because they may worsen diarrhea.\n" +
                              "\n" +
                              "Soft, bland foods are recommended as well, including bananas, plain rice, toast, " +
                              "crackers, boiled potatoes, smooth peanut butter, cottage cheese, noodles and applesauce." +
                              " Because yogurt, cheese and miso contain probiotics, which contain strains of bacteria " +
                              "similar to those in a healthy intestine, they are also good choices. Avoid fatty, " +
                              "high-fiber or heavily seasoned foods for several days. \n" +
                              "\n" +
                              "Lustbader also recommends taking steps to prevent diarrhea, especially when traveling." +
                              " These measures include drinking only bottled or boiled water, frequently washing your " +
                              "hands (especially before eating) and eating only freshly cooked foods.",

                      "The treatment given to someone with jaundice will depend on what type they have, " +
                              "how serious it is and what caused it.\n" +
                              "\n" +
                              "It may include tackling an underlying condition such as malaria and bothersome " +
                              "symptoms, such as itching.\n" +
                              "\n" +
                              "For genetic conditions that don't get better, like sickle cell anaemia, a blood " +
                              "transfusion may be given to replenish red blood cells in the body.\n" +
                              "\n" +
                              "If the bile duct system is blocked, an operation may be needed to unblock it. " +
                              "During these procedures measures may be taken to help prevent further problems, " +
                              "such as removal of the gallbladder.\n" +
                              "\n" +
                              "If the liver is found to be seriously damaged, a transplant may be an option.\n",

                      "If recognized early, malaria infection can be completely cured. You may be treated as an " +
                              "outpatient. The medication chosen by your doctor depends on:\n" +
                              "\n" +
                              "the type of malaria (knowing the species of parasite will help your doctor " +
                              "choose the most appropriate medication for you or determine whether hospitalization" +
                              " is necessary)\n" +
                              "the area you travelled to or visited when you contracted malaria (the doctor needs " +
                              "to know this because in certain geographical locations the malaria is resistant to" +
                              " some medications)\n" +
                              "the severity of the illness\n" +
                              "your medical history\n" +
                              "if you are pregnant\n" +
                              "Treatment usually lasts for 3 to 7 days, depending on the medication type. To get" +
                              " rid of the parasite, it's important to take the medication for the full length " +
                              "of time prescribed – don't stop taking the medication even if you feel better. " +
                              "If you experience any side effects, your doctor can recommend ways to manage " +
                              "them or may choose to give you a different medication.\n" +
                              "\n" +
                              "If you're travelling to a malarial region, you should take a course of preventive" +
                              " treatment. Medications similar to those used to cure malaria can prevent it if " +
                              "taken before, during, and after your trip. It's vital to take your medication as" +
                              " prescribed, even after you return home.\n" +
                              "\n" +
                              "Before travelling, check with your doctor or travel clinic about the region's " +
                              "malaria status. Risk of infection also depends on:\n" +
                              "\n" +
                              "altitude (lower altitudes have higher risk)\n" +
                              "camping vs. hotel stay\n" +
                              "length of stay\n" +
                              "rural vs. urban areas (rural areas have higher risk)\n" +
                              "season (infection is more common during the rainy season)\n" +
                              "time of day (night is worse)\n" +
                              "Since mosquitoes are night feeders, stay away from danger zones – particularly" +
                              " fields, forests, and swamps – from dusk to dawn to avoid being bitten. Use " +
                              "permethrin-treated mosquito netting when sleeping. Using mosquito coils and " +
                              "aerosolized insecticides containing pyrethroids may also help improve " +
                              "protection during this time.",

                      "Some of the same antiviral drugs that are used to treat seasonal flu also work against " +
                              "H1N1 swine flu. Oseltamivir (Tamiflu), peramivir (Rapivab), and zanamivir " +
                              "(Relenza) seem to work best, although some kinds of swine flu don’t respond to oseltamivir.\n" +
                              "\n" +
                              "These drugs can help you get well faster. They can also make you feel better. " +
                              "They work best when you take them within 48 hours of the first flu symptoms, " +
                              "but they can help even if you get them later on.\n" +
                              "\n" +
                              "Antibiotics won't do anything for you. That’s because flu is caused by a " +
                              "virus, not bacteria.\n" +
                              "\n" +
                              "Over-the-counter pain remedies and cold and flu medications can help " +
                              "relieve aches, pains, and fever. Don't give aspirin to children under " +
                              "age 18 because of the risk of Reye’s syndrome. Make sure that over-the-counter" +
                              " cold medications do not have aspirin before giving them to children.",

                      "If you are suffering from viral fever it is best that you take enough rest and have warm " +
                              "soothing food like soup and khichidi till you get better. If you have very severe " +
                              "symptoms like high fever, extreme body ache, etc. you should visit your doctor for" +
                              " some medicines to give you some symptomatic relief.\n" +
                              "A number of people tend to self medicate during such times, relying on " +
                              "antipyretics, analgesics and antibiotics to help them out, but remember " +
                              "that self-medication is a bad idea. Here’s why you don’t need medicine" +
                              " every time you have slight fever.\n" +
                              "More importantly a viral fever will not heal with antibiotics." +
                              " Antibiotics are medicines that are made to kill bacteria, " +
                              "they cannot kill viruses; so by taking them, all you are doing is " +
                              "heading towards a bad case of acidity, stomach disturbance and in" +
                              " more severe cases damage to your liver and kidneys. Read in detail" +
                              " about Antibiotics — types, side-effects, dosage and precautions.\n" +
                              "If your doctor has prescribed you antibiotics after diagnosing " +
                              "you with viral fever, it is usually to help beat any opportunistic" +
                              " or secondary infections you might catch while you are sick." +
                              " When prescribed it is important to complete the entire course of " +
                              "the medication, even if you are feeling better. This is because" +
                              " discontinuation of antibiotics midway leads to the formation of" +
                              " antibiotic-resistant bacteria. This is a risk factor not only " +
                              "for you but also others who might get infected by it."
              };

              item.setCure(disease_cure[index]);
              Log.d(LOG_TAG, "Cure is : " + item.getCure());
              Intent intent = new Intent(MainActivity.this, DiseaseDetail.class);
              intent.putExtra("name", item.getName())
                      .putExtra("age", item.getAge())
                      .putExtra("height", item.getHeight())
                      .putExtra("weight", item.getWeight())
                      .putExtra("bmi", item.getBmi())
                      .putExtra("diseasename", item.getDisease())
                      .putExtra("cure", item.getCure())
                      .putExtra("symptoms", item.getSymptoms())
                      .putExtra("cause", item.getCause());
              startActivity(intent);
          }
      });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
