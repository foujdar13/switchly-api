package live.switchly.api.exception;
import live.switchly.api.exception.FlagNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleOrganizationNotFound(
            OrganizationNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", Instant.now().toString(),
                        "status", 404,
                        "error", "Organization Not Found",
                        "message", ex.getMessage()
                )
        );
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProjectNotFound(
            ProjectNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", Instant.now().toString(),
                        "status", 404,
                        "error", "Project Not Found",
                        "message", ex.getMessage()
                )
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(
            IllegalArgumentException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                        "timestamp", Instant.now().toString(),
                        "status", 400,
                        "error", "Bad Request",
                        "message", ex.getMessage()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(
            Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                Map.of(
                        "timestamp", Instant.now().toString(),
                        "status", 500,
                        "error", "Internal Server Error",
                        "message", ex.getMessage() == null
                                ? "Something went wrong"
                                : ex.getMessage()
                )
        );
    }

    @ExceptionHandler(FlagNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleFlagNotFound(
            FlagNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", Instant.now().toString(),
                        "status", 404,
                        "error", "Flag Not Found",
                        "message", ex.getMessage()
                )
        );
    }

}