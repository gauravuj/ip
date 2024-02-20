package duke.conversation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Conversation {

    protected Hashtable<String, List<String>> dialogues;
    private final Random random;

    /**
     * Constructs a Conversation object.
     *
     * @param username the username
     */
    public Conversation(String username) {
        dialogues = new Hashtable<>();
        random = new Random();
        initializeDialogues(username);
    }

    /**
     * Adds a dialogue response for a specific key.
     *
     * @param key the key for the dialogue
     * @param response the response to be added
     */
    public void addDialogue(String key, String response) {
        key = key.toLowerCase();
        dialogues.computeIfAbsent(key, k -> new ArrayList<>()).add(response);
    }

    /**
     * Initializes the dialogues with common responses.
     *
     * @param username the username
     */
    public void initializeDialogues(String username) {
        addDialogue("bye", "Catch you later, alligator! 🐊");
        addDialogue("bye", "Goodbye! Don't forget to come back for more adventures! 🚀");

        addDialogue("hello", "Hi there! How can I make your day awesome? 😊");
        addDialogue("hello", "Greetings, Earthling! What adventures await us today?");

        addDialogue("hey", "Hey! Ready to conquer some tasks? 💪");
        addDialogue("hey", "Yo! What's up?");

        addDialogue("how are you", "Running at optimal efficiency! Thanks for checking in. 🤖");
        addDialogue("how are you", "I'm fantastic, thanks for asking! How about yourself?");

        addDialogue("what's your name", "I go by Sophia in these parts of the internet. And who do I have the pleasure of speaking with?");
        addDialogue("what's your name", "They call me Sophia. What's your codename?");

        // Adding more common conversations
        addDialogue("thank you", "You're welcome! Always here to help. 😊");
        addDialogue("thank you", "No problemo! If you need me, just shout! 📣");

        addDialogue("what can you do", "From managing tasks to telling jokes, I'm here to make life a tad easier. What's on your mind?");
        addDialogue("what can you do", "I'm like a Swiss Army knife for your tasks and questions! Try asking me something specific.");

        addDialogue("tell me a joke", "Why don't skeletons fight each other? They don't have the guts.");
        addDialogue("tell me a joke", "I'd tell you a UDP joke, but you might not get it... and I wouldn't get your response. 🤣");

        addDialogue("good morning", "Good morning! Let's kickstart this day with some positivity! 🌞");
        addDialogue("good morning", "Morning! If you had a dream last night, let's make it come true today!");

        addDialogue("good night", "Good night! May your dreams be full of adventures. 🌜");
        addDialogue("good night", "Nighty night! Don't let the bed bugs byte... err, I mean bite. 🐛");
    }

    /**
     * Retrieves a dialogue response based on the input message.
     *
     * @param message the input message
     * @return a dialogue response
     */
    public String printDialogue(String message) {
        StringBuilder dialogueMessage = new StringBuilder();
        List<String> dialoguesList = dialogues.get(message.toLowerCase());
        if (dialoguesList != null && !dialoguesList.isEmpty()) {
            String dialogue = dialoguesList.get(random.nextInt(dialoguesList.size()));
            dialogueMessage.append(dialogue);
        } else {
            dialogueMessage.append("Whoops! 🙈 I'm scratching my digital head because I'm not quite sure what '")
                    .append(message)
                    .append("' means. 🤔\nCould you spell that out for me again, or maybe try" +
                            " asking something else? Always here to help! 😊");

        }
        return dialogueMessage.toString();
    }
}
