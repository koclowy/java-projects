package oneminute.lists;

import java.util.ArrayList;
import oneminute.classes.*;

public class ItemList {

    private ArrayList<Item> itemInitList;

    public ArrayList<Item> getItemList() {
        itemInitList = new ArrayList<>(); 
        itemInitList.add(new Item("Battery", "For keeping your devices alive longer than your sanity.", "/oneminute/images/items/item_Battery.png"));
        itemInitList.add(new Item("Board Game", "Entertainment that doesn't need a Wi-Fi signal.","/oneminute/images/items/item_BoardGame.png"));
        itemInitList.add(new Item("Books", "Escaping reality one page at a time, because adventures are essential, even indoors.","/oneminute/images/items/item_Book.png"));
        itemInitList.add(new Item("Bug Spray", "Because even lockdown won't keep pests away.","/oneminute/images/items/item_BugSpray.png"));

        itemInitList.add(new Item("Candles", "Ambiance and emergency lighting rolled into one.","/oneminute/images/items/item_Candle.png"));
        itemInitList.add(new Item("Headphone", "Music: your escape from the four walls closing in.","/oneminute/images/items/item_Headphone.png"));
        itemInitList.add(new Item("Canned Foods", "Comfort in a tin can, because cooking's overrated.","/oneminute/images/items/item_CannedFood.png"));
        itemInitList.add(new Item("Cards", "Old-school fun for when the internet's down.","/oneminute/images/items/item_Cards.png"));
        
        itemInitList.add(new Item("Perfume", "Smelling good, even when there's no one to impress.","/oneminute/images/items/item_Perfume.png"));
        itemInitList.add(new Item("Deodorant", "Because social distancing doesn't mean smelling bad.","/oneminute/images/items/item_Deodorant.png"));
        itemInitList.add(new Item("Ice Cream", "Cold, creamy solace in a world gone crazy.","/oneminute/images/items/item_IceCream.png"));
        itemInitList.add(new Item("Maps", "Finding new escape routes or just daydreaming.","/oneminute/images/items/item_Map.png"));

        itemInitList.add(new Item("First Aid Kit", "For those unexpected 'ouch' moments at home.","/oneminute/images/items/item_FirstAidKit.png"));
        itemInitList.add(new Item("Soaps", "Warding off germs and maintaining lockdown hygiene.","/oneminute/images/items/item_Soap.png"));
        itemInitList.add(new Item("Weapon", "For when social distancing fails as a negotiation tactic.","/oneminute/images/items/item_Weapon.png"));
        itemInitList.add(new Item("Flashlight", "Shining a light on things that go bump in the night.","/oneminute/images/items/item_Flashlight.png"));

        itemInitList.add(new Item("Radio", "Stay connected to the world outside your front door.","/oneminute/images/items/item_Radio.png"));
        itemInitList.add(new Item("Pet Foods", "Because even furry friends need comfort during lockdown.","/oneminute/images/items/item_PetFood.png"));
        itemInitList.add(new Item("Matches", "Fire-starting expertise, for warmth or cooking adventures.","/oneminute/images/items/item_Matches.png"));
        itemInitList.add(new Item("Medicine", "Prescription for peace of mind in uncertain times.","/oneminute/images/items/item_Medicine.png"));

        itemInitList.add(new Item("Pillow", "Comfort for those unexpected naptime marathons.","/oneminute/images/items/item_Pillow.png"));
        itemInitList.add(new Item("Toilet Paper", "Defender of personal hygiene, even in quarantine.","/oneminute/images/items/item_ToiletPaper.png"));
        itemInitList.add(new Item("Water", "Hydration: because survival never takes a sick day.","/oneminute/images/items/item_Water.png"));
        itemInitList.add(new Item("Suitcase", "Packing for the great adventure of staying indoors.","/oneminute/images/items/item_Suitcase.png"));

        itemInitList.add(new Item("Stationary", "From cutting paper to makeshift haircuts, because survival requires versatile tools.","/oneminute/images/items/item_Stationary.png"));

        return itemInitList;
    }
}
