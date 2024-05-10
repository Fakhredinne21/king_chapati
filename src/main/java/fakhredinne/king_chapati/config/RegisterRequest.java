package fakhredinne.king_chapati.config;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname
                  ,lastname
                  ,email
                  ,password;

}
