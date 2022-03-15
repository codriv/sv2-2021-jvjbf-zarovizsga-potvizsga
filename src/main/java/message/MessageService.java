package message;

public class MessageService {

    private UserRepository userRepository;
    private MessageRepository messageRepository;

    public MessageService(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public void registerUser(String username) {
        if (userRepository.findUserByName(username).isEmpty()) {
            userRepository.insertUser(username);
        } else {
            throw new IllegalArgumentException("Username is already taken: " + username);
        }
    }

    public void sendMessage(User sender, User receiver, String message) {
        if (userRepository.findUserByName(sender.getUsername()).isPresent() && userRepository.findUserByName(receiver.getUsername()).isPresent()) {
            long senderId = userRepository.findUserByName(sender.getUsername()).get().getId();
            long receiverId = userRepository.findUserByName(receiver.getUsername()).get().getId();
            messageRepository.sendMessage(senderId, receiverId, message);
        } else {
            throw new IllegalArgumentException("User not found!");
        }
    }
}
