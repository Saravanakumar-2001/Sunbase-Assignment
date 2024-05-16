import com.example.ragchatbot.service.RAGChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final RAGChatbotService ragChatbotService;

    @Autowired
    public ApiController(RAGChatbotService ragChatbotService) {
        this.ragChatbotService = ragChatbotService;
    }

    @PostMapping("/api/upload")
    public ResponseEntity<String> uploadText(@RequestBody String text) {
        try {
            // Tokenize the text and count the number of words
            // For simplicity, let's just return the uploaded text
            return new ResponseEntity<>(text, HttpStatus.OK);
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return new ResponseEntity<>("Error processing uploaded text: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/api/chat")
    public ResponseEntity<String> chat(@RequestBody String query) {
        try {
            // Generate response using RAGChatbotService
            String response = ragChatbotService.generateResponse(query);

            // Return the generated response
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return new ResponseEntity<>("Error processing user query: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
