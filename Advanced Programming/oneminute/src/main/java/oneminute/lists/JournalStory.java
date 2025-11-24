package oneminute.lists;

import java.util.ArrayList;

public class JournalStory {
    private ArrayList<String> pagesDay1 = new ArrayList<>();
    private ArrayList<String> pagesDay2 = new ArrayList<>();
    private ArrayList<String> pagesDay3 = new ArrayList<>();
    private ArrayList<String> pagesDay4 = new ArrayList<>();
    private ArrayList<String> pagesDay5 = new ArrayList<>();
    private ArrayList<String> pagesDay6 = new ArrayList<>();
    private ArrayList<String> pagesDay7 = new ArrayList<>();
    private ArrayList<String> pagesDay8 = new ArrayList<>();
    private ArrayList<String> pagesDay9 = new ArrayList<>();
    private ArrayList<String> pagesDay10 = new ArrayList<>();
    private ArrayList<String> pagesDay11 = new ArrayList<>();
    private ArrayList<String> pagesDay12 = new ArrayList<>();
    private ArrayList<String> pagesDay13 = new ArrayList<>();
    private ArrayList<String> pagesDay14 = new ArrayList<>();

    public JournalStory(){
    //Day 1
        pagesDay1.add("Day 1: Alternative Diet\n" +
            "\n" +
            "\n" +
            "Guess what! We've cultivated our very own indoor garden! We've discovered a bunch of mushrooms growing on one of the "
            + "walls. They appear to be large enough to consume. Should we consider having a mushroom meal today?");
        pagesDay1.add("We learned something today. Tomato soup is our best friend, and mushrooms aren't. Yuck.\n" +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-All family member health (Decrease 10)");
        pagesDay1.add("We may be hungry, but there are just some things we will never eat. Wall fungus is one of them.\n" +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-All family member hunger bar (Decrease 10)");
    
            //Day 2
        pagesDay2.add("Day 2: Rationing Dilemma\n" + 
            "\n" + 
            "\n" +                 
            "With our supplies dwindling faster than expected, we're forced to implement stricter rationing measures. "
            + "Portion sizes shrink, and each meal becomes a battle of wills against our growling stomachs. "
            + "As our hunger grows, so does our desperation to make our remaining supplies last. "
            + "But we still need to eat, survive, and move on, right?");
        pagesDay2.add("We can't stand the hunger any longer, and we end up eating a meal to survive and move on.\n" +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-2 Canned Food\n" +
            "+All family member hunger bar (Increase 10)");
        pagesDay2.add("Sorry, We can't stand the hunger any longer, and we end up eating a meal to survive and move on.\n" +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-2 Canned Food\n" +
            "+All family member hunger bar (Increase 10)");

    //Day 3
        pagesDay3.add("Day 3: Coffee Run\n" + 
            "\n" + 
            "\n" + 
            "Robert is tired of drinking plain, tasteless water and is really craving a cup of coffee. "
            + "He misses the rich aroma and the jolt of energy from his favourite coffee shop, "
            + "which used to be just a few blocks away. Maybe someone should go on a coffee run to lift "
            + "everyone's spirits. But who will take the risk? Should we send someone? ");
        pagesDay3.add("Great, we got a whole pot of cold coffee! The taste is odd without sugar or milk, "
            + "but it's a welcome change from the bland tap water we've been drinking. The pot only "
            + "held a few cups, which we quickly consumed. Everyone feels more alert and ready for anything... "
            + "at least for the next five or so minutes." +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "+Everyone drinks coffee\n" +
            "+Everyone feels rested (+ 10 Health)\n" +
            "+Increases everyone's morale (+10 morale)"); 
        pagesDay3.add("We're not going to risk our health for this. We have more important things to "
            + "worry about. Those cracks in the walls aren't going to fix themselves!"); 
        
    //Day 4
        pagesDay4.add("Day 4: Toilet Paper Rationing\n" + 
            "\n" + 
            "\n" + 
            "Our toilet paper supply is dwindling fast, and we're faced with the tough decision of how to ration "
            + "it effectively. With each passing day, the rolls seem to shrink before our eyes, and tensions rise as "
            + "we grapple with the reality of our situation. Should we choose to manage this precious commodity?");
        pagesDay4.add("We decide to implement strict rationing measures, limiting each family member to "
            + "a specific number of squares per day. While this helps conserve our supply, tensions "
            + "remain high as we navigate the discomfort of using less than we're accustomed to." +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-Morale for each family member (-10 Morale)");
        pagesDay4.add("In a moment of desperation, we abandon all attempts at rationing and use the "
            + "toilet paper as we please. While this provides temporary relief, we soon face the consequences "
            + "of our recklessness as our supply dwindles even faster, leaving us in a precarious situation.!"+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-2 Toilet Paper"); 

    //Day 5
        pagesDay5.add("Day 5: Bread and Circuses\n" + 
            "\n" + 
            "\n" + 
            "Both Robert and Gwen are eyeing one of the canned foods in a very, very disturbing way. "
            + "Now it looks like they are going to duel over it using forks they found in the shelter. "
            + "This may get bloody. Shall we stop them?");
        pagesDay5.add("Robert got his fair share of the can. Gwen was watching his every move. "
            + "We had to step in and put everything in order. Some fair rationing is what "
            + "this shelter needs if we're going to survive.");
        pagesDay5.add("We decided to watch and enjoy what sick entertainment it was. The can soon found its "
            + "way to the ground and was spilled all over the floor. They didn't look too happy about it."+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-1 Canned Food\n" +
            "+Everybody get tired (-5 Morale)"); 

    //Day 6            
        pagesDay6.add("Day 6: Medical Emergency\n" + 
            "\n" + 
            "\n" + 
            "We've encountered a medical emergency in the shelter. Susan stumbled and fell, injuring her leg badly. "
            + "It's swollen, and she's in excruciating pain. We need to act fast. Should we use the First Aid Kit?");  
        pagesDay6.add("Thankfully, we have a well-stocked first aid kit. With careful attention and the "
            + "supplies from the kit, we manage to stabilize Susan's injury and alleviate her pain. "
            + "She'll need some time to recover, but it's a relief to see her comfortable for now." +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-1 First Aid Kit");
        pagesDay6.add("Without the proper medical supplies, we struggle to address Susan's "
            + "injury effectively. Her pain persists, and we're left feeling helpless. "
            + "We can only hope that her condition doesn't worsen without proper treatment."+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-Overall family morale and health decreases (-5 morale and health)"); 

    //Day 7
        pagesDay7.add("Day 7: Time to Ration Supplies\n" + 
            "\n" + 
            "\n" + 
            "As the days drag on, the strain of rationing our dwindling supplies weighs heavily on us. "
            + "Each passing day makes it more urgent to carefully portion out our remaining canned foods "
            + "and water. The stark reality of our situation is undeniable – we must make every bite count "
            + "if we are to survive until help arrives. It's time to eat.");
        pagesDay7.add("It's a delicious and satisfying meal, but we still feel hungry. Hope we still have more food to eat." +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-3 Canned Foods\n" +
            "-3 Water\n" +
            "\n" +
            "For everybody:\n " +
            "Hunger: +30 \n" +
            "Thirst: +30\n" +
            "Morale: +5 \n" +
            "Health: +5 ");
        pagesDay7.add("Sorry, We can't stand the hunger any longer, and we end up eating a meal to survive and move on."+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-3 Canned Foods\n" +
            "-3 Water\n" +
            "\n" +
            "For everybody:\n" +
            "Hunger: +30 \n" +
            "Thirst: +30\n" +
            "Morale: +5 \n" +
            "Health: +5 ");

    //Day 8
        pagesDay8.add("Day 8: Call of the Tuba\n" + 
            "\n" + 
            "\n" + 
            "Susan clearly misses her music lessons – she keeps humming her favourite classical pieces, imitating the "
            + "sound of tuba. She said she would die for a chance to play it again... which may very well happen if we "
            + "let her out of the shelter. If this would help to bring a smile to her weary face, maybe we should consider "
            + "letting her out for a short walk around the house above?");
        pagesDay8.add("Susan got very excited when we agreed to let her look for her tuba. She said if she can't "
            + "find the instrument, she'll settle for anything else she can find, like some sheet music. We "
            + "sure hope the tuba didn't make it... we're pretty sure we prefer radio static or even the sweet "
            + "sound of silence." +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "+Increases everyone’s morale (+10 morale)");
        pagesDay8.add("Risking your life for a tuba? Madness. If it was a guitar or at least a trumpet…"
            + " but a tuba? Playing the tuba won’t put soup on the table! Susan isn’t happy, but she "
            + "needs to realize how pointless this idea was. "+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "+Decreases everyone's morale (-10 morale)");

    //Day 9
        pagesDay9.add("Day 9: Blackout Emergency\n" + 
            "\n" + 
            "\n" + 
            "A sudden blackout plunges our shelter into darkness, leaving us disoriented and vulnerable. "
            + "With no electricity to rely on, we're forced to navigate through the darkness using only our "
            + "flashlight and limited battery supply. How will we manage this unforeseen crisis? "
            + "Should we use our flashlight and battery?");
        pagesDay9.add("We quickly gather our flashlight and spare batteries, relying on their faint glow to"
            + " illuminate our surroundings. While navigating through the darkness is challenging, the "
            + "flashlight provides a sense of security, allowing us to move cautiously and avoid potential "
            + "hazards." +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "+10 Morale for each family member\n" +
            "-1 Flashlight\n" +
            "-1 Battery");
        pagesDay9.add("Opting to conserve our battery supply, we choose to stumble through the darkness without the aid "
            + "of a flashlight. However, our decision proves costly as we struggle to navigate our surroundings,"
            + " tripping over objects and risking injury in the process."+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-10 Morale for each family member\n" +
            "-10 Health for each family member due to potential injuries");

    //Day 10
        pagesDay10.add("Day 10: Danger of the Wasteland\n" + 
            "\n" + 
            "\n" + 
            "We've been hearing a lot of commotion in the neighbourhood today. It seems like there's "
            + "a group of people looting nearby stores. They're not getting away with that! This might "
            + "be the perfect opportunity to gather some fresh supplies. Should we send someone to go out and investigate?");
        pagesDay10.add("We found the group and managed to grab some supplies while they were distracted. "
            + "We ended up with a few cans of food that will surely help us get through these tough times." +
            "\n" +
            "\n" +
            "Outcome:\n" +
            "+3 Canned Foods");
        pagesDay10.add("A scavenging mission sounds way too risky. What if the situation outside is more dangerous than we think? "
            + "It’s better to stay safe inside and avoid unnecessary risks.");
            
    //Day 11
        pagesDay11.add("Day 11: Water Shortage\n" + 
            "\n" + 
            "\n" + 
            "Today brings an unexpected challenge as our water supply unexpectedly runs dry. With no water for basic hygiene, "
            + "we're left feeling uncomfortable and vulnerable. Should we resort to using deodorant to mask the lack of bathing?");
        pagesDay11.add("Opting for a quick fix, we liberally apply the deodorant, hoping to stave off the effects of the water "
            + "shortage on our personal hygiene. While the deodorant offers a temporary solution, it's no substitute for proper "
            + "bathing. Nevertheless, it provides some relief amidst the discomfort."+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "+10 Morale for each family member\n" +
            "-1 Deodorant");
        pagesDay11.add("Prolonging the discomfort of the water shortage, we endure the day without resorting to deodorant."
            + " However, as the day wears on, the lack of hygiene takes its toll, resulting in a decline "
            + "in morale for each family member. The oppressive atmosphere serves as a stark reminder of the "
            + "challenges we face in maintaining our well-being amidst scarcity."+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-10 Morale for each family member\n" +
            "-10 All character health");

    //Day 12
        pagesDay12.add("Day 12:  Reunited (Infected Camp)\n" + 
            "\n" + 
            "\n" + 
            "A young woman, dressed in protective gear, visited us today, requesting our help. "
            + "Wasting no time, she explained that her twin brother is trapped in a nearby camp overrun "
            + "with infected individuals. It seems the young man was foolish enough to confront the leader "
            + "of a dangerous group hoarding supplies, and now his sister is very worried. She insists we won't "
            + "regret it if we decide to help her.");
        pagesDay12.add("The woman quickly called a group of friends, and we set out on what turned out to be a "
            + "successful mission. Finding the lost twin brother wasn't a problem – he was perched on top of "
            + "a makeshift tower, trying to avoid the infected. In his confrontation with the camp leader, he "
            + "suffered a serious injury, but the group quickly tended to his wounds, and he'll recover. The "
            + "siblings thanked us profusely and provided us with some of their supplies as a token of their "
            + "gratitude."+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "+3 Canned Foods\n" +
            "+1 First Aid Kit\n" +
            "+Boost to Morale ( +10 morale )");
        pagesDay12.add("Heading deep into an infected camp, looking for a confrontation? These people seem "
            + "well-meaning, but we just can't take the risk right now. Perhaps another time.");

    //Day 13
        pagesDay13.add("Day 13: Pest Infestation \n" + 
            "\n" + 
            "\n" + 
            "An unpleasant discovery awaits us as we find our shelter invaded by a horde of pesky insects. "
            + "These critters threaten our hygiene and comfort, leaving us with no choice but to address the "
            + "infestation. Should we use bug spray to tackle this nuisance head-on?");  
        pagesDay13.add("With determination, we unleash the bug spray, filling the air with its potent scent. "
            + "The insects scatter and retreat, granting us temporary relief from the infestation. While "
            + "the smell lingers, it's a small price to pay for reclaiming our shelter from these unwanted "
            + "guests."+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "+5 Morale for each family member\n" +
            "-1 Bug spray");
        pagesDay13.add("I'm sorry but we don't have bug spray at the moment. Without bug spray, we attempt to endure the "
            + "insect invasion without intervention. "
            + "However, the pests continue to proliferate, posing a persistent threat to our hygiene and well-being. "
            + "Our reluctance to use the bug spray results in prolonged discomfort and frustration."+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "-10 Morale for each family member\n" +
            "-10 All character health");

    //Day 14
        pagesDay14.add("Day 14: The Quarantine Cookie Stand\n" + 
            "\n" + 
            "\n" + 
            "As we cautiously approached the door upon hearing a knock, we were relieved to find a pair "
            + "of girls' voices outside. It was the local Girl Scouts, adapting their cookie-selling business to"
            + " these challenging times. Resourceful kids. Should we accept their trade?");
        pagesDay14.add("Impressed by the Girl Scouts' innovative spirit during the pandemic, we gladly accepted their offer. "
            + "Their fair prices and array of items provided a much-needed boost to our supplies."+
            "\n" +
            "\n" +
            "Outcome:\n" +
            "+5 Canned Foods\n" +
            "+1 Medical Kit\n" +
            "-3 Water");
        pagesDay14.add("While we admired the Girl Scouts' courage in navigating the current situation, "
            + "their offerings didn't align with our immediate needs. Politely, we declined, albeit missing "
            + "out on potential supplies.");
    }

    public ArrayList<String> getPagesForDay(int day) {
        switch (day) {
            case 1: return pagesDay1;
            case 2: return pagesDay2;
            case 3: return pagesDay3;
            case 4: return pagesDay4;
            case 5: return pagesDay5;
            case 6: return pagesDay6;
            case 7: return pagesDay7;
            case 8: return pagesDay8;
            case 9: return pagesDay9;
            case 10: return pagesDay10;
            case 11: return pagesDay11;
            case 12: return pagesDay12;
            case 13: return pagesDay13;
            case 14: return pagesDay14;
            default: return new ArrayList<>();
        }
    }

    public String getPage(int day, int index) {
        ArrayList<String> pages = getPagesForDay(day);
        if (index >= 0 && index < pages.size()) {
            return pages.get(index);
        }
        return "";
    }

    public String getYesChoice(int day) {
        return getPage(day, 1);
    }

    public String getNoChoice(int day) {
        return getPage(day, 2);
    }
    
}
