package org.jpa.chatentiemporeal.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
@Configuration
public class FirebaseConfig {
    FileInputStream serviceAccount =
            new FileInputStream("src/main/resources/chat-real-time-b7a0b-firebase-adminsdk-fbsvc-6a4bc2689e.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://chat-real-time-b7a0b-default-rtdb.firebaseio.com")
            .build();

    public FirebaseConfig() throws IOException {
        FirebaseApp.initializeApp(options);
    }


}*/
