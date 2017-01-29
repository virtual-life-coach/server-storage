package vlc.ss.dao;

import com.googlecode.objectify.ObjectifyService;
import vlc.common.to.ReceiptTO;
import vlc.ss.datastore.Receipt;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class EntityDAO {

    public static Logger log = Logger.getLogger(EntityDAO.class.getName());

    static {
        ObjectifyService.register(Receipt.class);
    }

    public static ReceiptTO getRandomReceipt() {
        List<Receipt> receiptList = ofy().load().type(Receipt.class).list();
        log.info("Receipts: " + receiptList);
        Receipt randomReceipt = receiptList.get(new Random().nextInt(receiptList.size()));
        return new ReceiptTO(randomReceipt.getId(), randomReceipt.getText());
    }


    /*
    public static void insertReceipts() {
        List<Receipt> receipts = new ArrayList<>();
        receipts.add(new Receipt(null,
                "Easy spaghetti Bolognese\n\nPreparation time\n" +
                        "less than 30 mins\n" +
                        "Cooking time\n" +
                        "30 mins to 1 hour\n" +
                        "Serves\n" +
                        "Serves 4\n\nA classic Bolognese sauce still tastes great, no matter how simple. Get that depth of flavour by cooking the sauce very gently until itâ€™s super rich. This is designed to be a low cost recipe.\n" +
                        "\n" +
                        "Try the Eat Well for Less quiz to find out how you could cut your food bills.\n" +
                        "\n" +
                        "This sauce can be cooked in advance and frozen. Leave to cool completely then pop in a freezer-proof container, it will keep in the freezer for up to 2 months.\n\n2 tbsp olive oil\n" +
                        "400g/14oz beef mince\n" +
                        "1 onion, diced\n" +
                        "2 garlic cloves, chopped\n" +
                        "100g/1/2oz carrot, grated\n" +
                        "2 x 400g tin chopped tomatoes\n" +
                        "400ml/14fl oz stock (made from stock cube. Ideally beef, but any will do)\n" +
                        "400g/14oz dried spaghetti\n" +
                        "salt and pepper\n\nMethod\n" +
                        "Heat a large saucepan over a medium heat. Add a tablespoon of olive oil and once hot add the beef mince and a pinch of salt and pepper. Cook the mince until well browned over a medium-high heat (be careful not to burn the mince. It just needs to be a dark brown colour). Once browned, transfer the mince to a bowl and set aside.\n" +
                        "Add another tablespoon of oil to the saucepan you browned the mince in and turn the heat to medium. Add the onions and a pinch of salt and fry gently for 5-6 minutes, or until softened and translucent. Add the garlic and cook for another 2 minutes. Add the grated carrot then pour the mince and any juices in the bowl back into the saucepan.\n" +
                        "Add the tomatoes to the pan and stir well to mix. Pour in the stock, bring to a simmer and then reduce the temperature to simmer gently for 45 minutes, or until the sauce is thick and rich. Taste and adjust the seasoning as necessary.\n" +
                        "When ready to cook the spaghetti, heat a large saucepan of water and add a pinch of salt. Cook according to the packet instructions. Once the spaghetti is cooked through, drain and add to the pan with the bolognese sauce. Mix well and serve."));

        receipts.add(new Receipt(null, "Almond and parsley crumb fish with a roasted red pepper sauce and nibbles\nPreparation time\n" +
                "less than 30 mins\n" +
                "Cooking time\n" +
                "30 mins to 1 hour\n" +
                "Serves\n" +
                "Serves 4\n\nIngredients\n" +
                "For the seafood\n" +
                "1 x 300g/1/2oz cod fillet, pin boned and diced\n" +
                "2 x 100g/1/2oz red mullet fillets, pin boned and diced\n" +
                "12 prawns, shells removed\n" +
                "12 langoustines, shells removed, blanched\n" +
                "2 tbsp Dijon mustard\n" +
                "200g/7oz flaked almonds, crushed\n" +
                "2 tbsp fresh parsley, chopped\n" +
                "For the roasted red pepper sauce\n" +
                "1 slice sourdough bread, cut into cubes\n" +
                "1/2 red chilli, finely chopped\n" +
                "2 garlic cloves, finely chopped\n" +
                "50ml/2fl oz extra virgin olive oil\n" +
                "3 plum tomatoes\n" +
                "100g/Â½oz flaked almonds, toasted\n" +
                "1/2 tbsp smoked Spanish paprika\n" +
                "1/2 jar roasted red peppers\n" +
                "1 lemon, juice only\n" +
                "lemon wedges\n" +
                "salt and freshly ground black pepper\n" +
                "For the nibbles (optional)\n" +
                "Manchego cheese shavings\n" +
                "Iberico ham\n" +
                "Membrillo cubes\n\nMethod\n" +
                "For the seafood, heat a deep-fat fryer to 180C. (CAUTION: hot oil can be dangerous. Do not leave unattended.)\n" +
                "Brush the fish and seafood with the Dijon mustard. Season with salt and pepper. Mix the crushed flaked almonds and chopped parsley together, then press onto the fish and seafood to coat.\n" +
                "Place in the deep-fat fryer and cook for 2-3 minutes, depending on the size of the seafood. Remove using a slotted spoon and set aside to drain on kitchen paper.\n" +
                "For the roasted red pepper sauce, gently fry the bread, chilli and garlic in a pan with a little oil until the bread begins to colour.\n" +
                "Transfer the pan contents to a blender. Add the tomatoes, almonds, smoked paprika and peppers. PurÃ©e the mixture then add the lemon juice and a little olive oil. Season to taste with salt and pepper.\n" +
                "To serve, place the sauce on a serving platter and put the fish, prawns and langoustines on top. Serve the nibbles alongside."));
        ofy().save().entities(receipts).now();
        log.info("Stored receipts.");
    }
    */

    /*
    public static void main(String[] args) {
        //String text = "Easy spaghetti Bolognese\n\nPreparation time\nless than 30 mins\nCooking time\n30 mins to 1 hour\nServes\nServes 4\n\nA classic Bolognese sauce still tastes great, no matter how simple. Get that depth of flavour by cooking the sauce very gently until itâ€™s super rich. This is designed to be a low cost recipe.\n\nTry the Eat Well for Less quiz to find out how you could cut your food bills.\n\nThis sauce can be cooked in advance and frozen. Leave to cool completely then pop in a freezer-proof container, it will keep in the freezer for up to 2 months.\n\n2 tbsp olive oil\n400g/14oz beef mince\n1 onion, diced\n2 garlic cloves, chopped\n100g/1/2oz carrot, grated\n2 x 400g tin chopped tomatoes\n400ml/14fl oz stock (made from stock cube. Ideally beef, but any will do)\n400g/14oz dried spaghetti\nsalt and pepper\n\nMethod\nHeat a large saucepan over a medium heat. Add a tablespoon of olive oil and once hot add the beef mince and a pinch of salt and pepper. Cook the mince until well browned over a medium-high heat (be careful not to burn the mince. It just needs to be a dark brown colour). Once browned, transfer the mince to a bowl and set aside.\nAdd another tablespoon of oil to the saucepan you browned the mince in and turn the heat to medium. Add the onions and a pinch of salt and fry gently for 5-6 minutes, or until softened and translucent. Add the garlic and cook for another 2 minutes. Add the grated carrot then pour the mince and any juices in the bowl back into the saucepan.\nAdd the tomatoes to the pan and stir well to mix. Pour in the stock, bring to a simmer and then reduce the temperature to simmer gently for 45 minutes, or until the sauce is thick and rich. Taste and adjust the seasoning as necessary.\nWhen ready to cook the spaghetti, heat a large saucepan of water and add a pinch of salt. Cook according to the packet instructions. Once the spaghetti is cooked through, drain and add to the pan with the bolognese sauce. Mix well and serve.";
        String text = "Almond and parsley crumb fish with a roasted red pepper sauce and nibbles\nPreparation time\nless than 30 mins\nCooking time\n30 mins to 1 hour\nServes\nServes 4\n\nIngredients\nFor the seafood\n1 x 300g/1/2oz cod fillet, pin boned and diced\n2 x 100g/1/2oz red mullet fillets, pin boned and diced\n12 prawns, shells removed\n12 langoustines, shells removed, blanched\n2 tbsp Dijon mustard\n200g/7oz flaked almonds, crushed\n2 tbsp fresh parsley, chopped\nFor the roasted red pepper sauce\n1 slice sourdough bread, cut into cubes\n1/2 red chilli, finely chopped\n2 garlic cloves, finely chopped\n50ml/2fl oz extra virgin olive oil\n3 plum tomatoes\n100g/Â½oz flaked almonds, toasted\n1/2 tbsp smoked Spanish paprika\n1/2 jar roasted red peppers\n1 lemon, juice only\nlemon wedges\nsalt and freshly ground black pepper\nFor the nibbles (optional)\nManchego cheese shavings\nIberico ham\nMembrillo cubes\n\nMethod\nFor the seafood, heat a deep-fat fryer to 180C. (CAUTION: hot oil can be dangerous. Do not leave unattended.)\nBrush the fish and seafood with the Dijon mustard. Season with salt and pepper. Mix the crushed flaked almonds and chopped parsley together, then press onto the fish and seafood to coat.\nPlace in the deep-fat fryer and cook for 2-3 minutes, depending on the size of the seafood. Remove using a slotted spoon and set aside to drain on kitchen paper.\nFor the roasted red pepper sauce, gently fry the bread, chilli and garlic in a pan with a little oil until the bread begins to colour.\nTransfer the pan contents to a blender. Add the tomatoes, almonds, smoked paprika and peppers. PurÃ©e the mixture then add the lemon juice and a little olive oil. Season to taste with salt and pepper.\nTo serve, place the sauce on a serving platter and put the fish, prawns and langoustines on top. Serve the nibbles alongside.";
        //System.out.println(text);
        byte[] bytes = text.getBytes();
        System.out.println(bytes);
        String ascii = new String(bytes, Charset.forName("US-ASCII"));
        System.out.println(ascii);
        //byte[] ascii = "Java".getBytes(StandardCharsets.US_ASCII); String asciiString = Arrays.toString(ascii); System.out.println(asciiString);
        //Read more: http://javarevisited.blogspot.com/2015/07/how-to-convert-string-or-char-to-ascii-example.html#ixzz4X9kGhQMH
    }
    */
}
