package com.example.jaypa.quizquest;

/**
 * Created by jaypa on 4/10/2017.
 */

public class Questions {

    public Questions(DatabaseHelper helper){
        QuizData qdata = new QuizData();
        helper.questionsExit = true;

        //Florida Questions
        qdata.setQuestion("What state borders Florida on the west?");
        qdata.setLocation("FLORIDA");
        qdata.setOp1("Mississippi");
        qdata.setOp2("Georgia");
        qdata.setOp3("Alabama");
        qdata.setOp4("Illinois");
        qdata.setAnswer("Alabama");
        helper.insertQuestion(qdata);

        qdata.setQuestion("What is the highest point in Florida?");
        qdata.setLocation("FLORIDA");
        qdata.setOp1("Miami");
        qdata.setOp2("Tallahassee");
        qdata.setOp3("Britton Hill");
        qdata.setOp4("");
        qdata.setAnswer("Tallahassee");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Which of the following is a city in Florida?");
        qdata.setLocation("FLORIDA");
        qdata.setOp1("Fort Lauderdale");
        qdata.setOp2("Miami");
        qdata.setOp3("Tallahassee");
        qdata.setOp4("All of the above");
        qdata.setAnswer("All of the above");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Florida is the ______ biggest state in the USA.");
        qdata.setLocation("FLORIDA");
        qdata.setOp1("2nd");
        qdata.setOp2("22nd");
        qdata.setOp3("42nd");
        qdata.setOp4("");
        qdata.setAnswer("22nd");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Florida was the _______ state to enter the union.");
        qdata.setLocation("FLORIDA");
        qdata.setOp1("27th");
        qdata.setOp2("37th");
        qdata.setOp3("47th");
        qdata.setOp4("50th");
        qdata.setAnswer("27th");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Which famous explorer first saw Florida?");
        qdata.setLocation("FLORIDA");
        qdata.setOp1("Christopher Columbus");
        qdata.setOp2("Ponce de Leon ");
        qdata.setOp3("Ferdinand Magellan");
        qdata.setOp4("");
        qdata.setAnswer("Ponce de Leon ");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Florida's official flag was adopted in what year?");
        qdata.setLocation("FLORIDA");
        qdata.setOp1("1900");
        qdata.setOp2("1945");
        qdata.setOp3("1985");
        qdata.setOp4("");
        qdata.setAnswer("1900");
        helper.insertQuestion(qdata);

        qdata.setQuestion("True or False? Florida is the only state that has 2 rivers with the same name.");
        qdata.setLocation("FLORIDA");
        qdata.setOp1("True");
        qdata.setOp2("False");
        qdata.setOp3("");
        qdata.setOp4("");
        qdata.setAnswer("True");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Where are all of the Governor's portraits?");
        qdata.setLocation("FLORIDA");
        qdata.setOp1("Key Largo");
        qdata.setOp2("Historic Capitol");
        qdata.setOp3("Space City");
        qdata.setOp4("");
        qdata.setAnswer("Historic Capitol");
        helper.insertQuestion(qdata);

        //Illinois Questions
        qdata.setQuestion("What does ‘Chicago’ mean?");
        qdata.setLocation("ILLINOIS");
        qdata.setOp1("onion field");
        qdata.setOp2("windy city");
        qdata.setOp3("hot dog");
        qdata.setOp4("Algonquian");
        qdata.setAnswer("onion field");
        helper.insertQuestion(qdata);

        qdata.setQuestion("The Art Institute of Chicago holds the largest collection of ______ in the US.");
        qdata.setLocation("ILLINOIS");
        qdata.setOp1("Sculpture");
        qdata.setOp2("Modern paintings");
        qdata.setOp3("Impressionist paintings");
        qdata.setOp4("Murals");
        qdata.setAnswer("Impressionist paintings");
        helper.insertQuestion(qdata);

        qdata.setQuestion("The Great Chicago Fire destroyed much of the city and killed hundreds of people. When did it occur?");
        qdata.setLocation("ILLINOIS");
        qdata.setOp1("1901");
        qdata.setOp2("1855");
        qdata.setOp3("1871");
        qdata.setOp4("1774");
        qdata.setAnswer("1871");
        helper.insertQuestion(qdata);

        qdata.setQuestion("As of 2017, who is the current mayor of Chicago?");
        qdata.setLocation("ILLINOIS");
        qdata.setOp1("Bob Blgojevich");
        qdata.setOp2("Rahm Emanuel");
        qdata.setOp3("Richard Daley");
        qdata.setOp4("Dick Cheney");
        qdata.setAnswer("Rahm Emanuel");
        helper.insertQuestion(qdata);

        qdata.setQuestion("How tall is the Willis Tower?");
        qdata.setLocation("ILLINOIS");
        qdata.setOp1("1,899 feet");
        qdata.setOp2("2,000 feet");
        qdata.setOp3("1,973 feet");
        qdata.setOp4("1,450 feet");
        qdata.setAnswer("1,450 feet");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Which Chicago sports team won 3 consecutive championships from 1991-1994?");
        qdata.setLocation("ILLINOIS");
        qdata.setOp1("Chicago Bears");
        qdata.setOp2("Chicago White Sox");
        qdata.setOp3("Chicago Cubs");
        qdata.setOp4("Chicago Bulls");
        qdata.setAnswer("Chicago Bulls");
        helper.insertQuestion(qdata);

        qdata.setQuestion("When did the Chicago cubs win the world series?");
        qdata.setLocation("ILLINOIS");
        qdata.setOp1("1909");
        qdata.setOp2("1999");
        qdata.setOp3("2016");
        qdata.setOp4("2007");
        qdata.setAnswer("2016");
        helper.insertQuestion(qdata);

        // New York
        qdata.setQuestion("What is the official insect of the state of New York?");
        qdata.setLocation("NEW YORK");
        qdata.setOp1("Ladybug");
        qdata.setOp2("Firefly");
        qdata.setOp3("Honeybee");
        qdata.setOp4("");
        qdata.setAnswer("Ladybug");
        helper.insertQuestion(qdata);

        qdata.setQuestion("What is the motto of the state of New York?");
        qdata.setLocation("NEW YORK");
        qdata.setOp1("It grows as it goes");
        qdata.setOp2("Liberty and prosperity");
        qdata.setOp3("Ever upward");
        qdata.setOp4("");
        qdata.setAnswer("Ever upward");
        helper.insertQuestion(qdata);

        qdata.setQuestion("What is the highest point in New York?");
        qdata.setLocation("NEW YORK");
        qdata.setOp1("Mount Washington (6,288 feet)");
        qdata.setOp2("Spruce Knob (4,861 feet)");
        qdata.setOp3("Mount Marcy (5,344 feet)");
        qdata.setOp4("");
        qdata.setAnswer("Mount Marcy (5,344 feet)");
        helper.insertQuestion(qdata);

        qdata.setQuestion("What is the capital city of New York?");
        qdata.setLocation("NEW YORK");
        qdata.setOp1("New York");
        qdata.setOp2("Albany");
        qdata.setOp3("Buffalo");
        qdata.setOp4("");
        qdata.setAnswer("Albany");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Which of these United States Presidents was born in New York?");
        qdata.setLocation("NEW YORK");
        qdata.setOp1("Franklin Pierce");
        qdata.setOp2("Gerald Rudolph Ford");
        qdata.setOp3("Theodore Roosevelt");
        qdata.setOp4("");
        qdata.setAnswer("Theodore Roosevelt");
        helper.insertQuestion(qdata);


        //California
        qdata.setQuestion("What US state borders California to the north?");
        qdata.setLocation("CALIFORNIA");
        qdata.setOp1("Washington");
        qdata.setOp2("Idaho");
        qdata.setOp3("Montana");
        qdata.setOp4("Oregon");
        qdata.setAnswer("Oregon");
        helper.insertQuestion(qdata);

        qdata.setQuestion("What city is the capital of the state of California? ");
        qdata.setLocation("CALIFORNIA");
        qdata.setOp1("San Jose");
        qdata.setOp2("Sacramento");
        qdata.setOp3("Los Angeles");
        qdata.setOp4("San Francisoc");
        qdata.setAnswer("Sacramento");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Where does California rank as far as area when compared to the rest of the states?");
        qdata.setLocation("CALIFORNIA");
        qdata.setOp1("Ninth Largest");
        qdata.setOp2("Third Largest");
        qdata.setOp3("Fifth Largest");
        qdata.setOp4("Sixth Largest");
        qdata.setAnswer("Third Largest");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Who was the only US President to be born in California?");
        qdata.setLocation("CALIFORNIA");
        qdata.setOp1("Richard Nixon");
        qdata.setOp2("Herbert Hoover");
        qdata.setOp3("Ronald Regan");
        qdata.setOp4("Bill Clinton");
        qdata.setAnswer("Richard Nixon");
        helper.insertQuestion(qdata);

        qdata.setQuestion("how many NBA basketball team does California have?");
        qdata.setLocation("CALIFORNIA");
        qdata.setOp1("1");
        qdata.setOp2("4");
        qdata.setOp3("2");
        qdata.setOp4("3");
        qdata.setAnswer("4");
        helper.insertQuestion(qdata);

        // Arizona
        qdata.setQuestion("How many counties does the state of Arizona have?");
        qdata.setLocation("ARIZONA");
        qdata.setOp1("13");
        qdata.setOp2("14");
        qdata.setOp3("15");
        qdata.setOp4("16");
        qdata.setAnswer("15");
        helper.insertQuestion(qdata);

        qdata.setQuestion("How long is Arizona's border with Mexico in miles?");
        qdata.setLocation("ARIZONA");
        qdata.setOp1("262 miles");
        qdata.setOp2("304 miles");
        qdata.setOp3("389 miles");
        qdata.setOp4("416 miles");
        qdata.setAnswer("389 miles");
        helper.insertQuestion(qdata);

        qdata.setQuestion("What is the Arizona state tree:");
        qdata.setLocation("ARIZONA");
        qdata.setOp1("Ponderosa Pine");
        qdata.setOp2("Douglas Fir");
        qdata.setOp3("Palo Verde");
        qdata.setOp4("Spruce");
        qdata.setAnswer("Palo Verde");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Of the US States, where does Arizona rank in size?");
        qdata.setLocation("ARIZONA");
        qdata.setOp1("6th");
        qdata.setOp2("5th");
        qdata.setOp3("7th");
        qdata.setOp4("9th");
        qdata.setAnswer("6th");
        helper.insertQuestion(qdata);

        qdata.setQuestion("What famous geological feature in Arizona is one of the seven natural wonders of the world?");
        qdata.setLocation("ARIZONA");
        qdata.setOp1("Death Valley");
        qdata.setOp2("Grand Tetons");
        qdata.setOp3("Grand Canyon");
        qdata.setOp4("Yellowstone");
        qdata.setAnswer("Grand Canyon");
        helper.insertQuestion(qdata);

        // GEORGIA
        qdata.setQuestion("What is Georgia's capital city?");
        qdata.setLocation("GEORGIA");
        qdata.setOp1("Columbus");
        qdata.setOp2("Savannah");
        qdata.setOp3("Atlanta");
        qdata.setOp4("Macon");
        qdata.setAnswer("Atlanta");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Georgia is the world's number one producer of what agricultural product?");
        qdata.setLocation("GEORGIA");
        qdata.setOp1("Peanuts");
        qdata.setOp2("pecans");
        qdata.setOp3("Walnuts");
        qdata.setOp4("Hazelnuts");
        qdata.setAnswer("pecans");
        helper.insertQuestion(qdata);

        qdata.setQuestion("What is the highest temperature ever recorded for the state of Georgia?");
        qdata.setLocation("GEORGIA");
        qdata.setOp1("119 °F");
        qdata.setOp2("117 °F");
        qdata.setOp3("112 °F");
        qdata.setOp4("109 °F");
        qdata.setAnswer("112 °F");
        helper.insertQuestion(qdata);

        qdata.setQuestion("What US state borders Georgia on the west?");
        qdata.setLocation("GEORGIA");
        qdata.setOp1("Tennessee");
        qdata.setOp2("Pennsylvania");
        qdata.setOp3("Florida");
        qdata.setOp4("Alabama");
        qdata.setAnswer("Alabama");
        helper.insertQuestion(qdata);

        qdata.setQuestion("What is the official Georgia state fish?");
        qdata.setLocation("GEORGIA");
        qdata.setOp1("Sturgeon");
        qdata.setOp2("Channel Catfish");
        qdata.setOp3("Large Mouth Bass");
        qdata.setOp4("Striped Bass");
        qdata.setAnswer("Large Mouth Bass");
        helper.insertQuestion(qdata);

        // MONTANA
        qdata.setQuestion("Who was the first governor of the STATE of Montana?");
        qdata.setLocation("MONTANA");
        qdata.setOp1("Joseph Toole");
        qdata.setOp2("Thomas Francis Meagher");
        qdata.setOp3("Sidney Edgerton");
        qdata.setOp4("Donald Nutter");
        qdata.setAnswer("Joseph Toole");
        helper.insertQuestion(qdata);

        qdata.setQuestion("For whom is Running Eagle Falls in the Two Medicine area of Glacier National Park named?");
        qdata.setLocation("MONTANA");
        qdata.setOp1("A Blackfeet woman warrior");
        qdata.setOp2("A Salish scout");
        qdata.setOp3("An eagle spirit that appeared during salmon spawning");
        qdata.setOp4("An early Blackfeet performer in the park");
        qdata.setAnswer("A Blackfeet woman warrior");
        helper.insertQuestion(qdata);

        qdata.setQuestion("How many bones did Butte daredevil Evel Knievel fracture?");
        qdata.setLocation("MONTANA");
        qdata.setOp1("None");
        qdata.setOp2("150");
        qdata.setOp3("35");
        qdata.setOp4("433");
        qdata.setAnswer("433");
        helper.insertQuestion(qdata);

        qdata.setQuestion("About which river has been said, \"A mile wide, an inch deep, too thin to plow, too thick to drink?\"");
        qdata.setLocation("MONTANA");
        qdata.setOp1("Big Muddy Creek");
        qdata.setOp2("Musselshell River");
        qdata.setOp3("Powder River");
        qdata.setOp4("Tobacco River");
        qdata.setAnswer("Powder River");
        helper.insertQuestion(qdata);

        qdata.setQuestion("Which is the capital of Montana?");
        qdata.setLocation("MONTANA");
        qdata.setOp1("Livingston");
        qdata.setOp2("Helena");
        qdata.setOp3("Billings");
        qdata.setOp4("");
        qdata.setAnswer("Helena");
        helper.insertQuestion(qdata);

/**
        qdata.setQuestion("");
        qdata.setLocation("ILLINOIS");
        qdata.setOp1("");
        qdata.setOp2("");
        qdata.setOp3("");
        qdata.setOp4("");
        qdata.setAnswer("");
        helper.insertQuestion(qdata);
**/
    }
}
