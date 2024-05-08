package fakhredinne.king_chapati.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.eclipse.angus.mail.util.BASE64DecoderStream;
import org.springframework.stereotype.Service;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY="3ABD28343723177DE381D177953D1";
   //Extract Username
    public String extractUsername(String token
    ) {
        return extractClaim(token,Claims::getSubject);
    }

    //Extract One Single Claims
    public <T> T extractClaim (String token, Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    //Extract Many Claims
  private Claims extractAllClaims(String token){
        //Extratc all claims of that specific token
        return Jwts.parser().
                setSigningKey(getSignInkey())
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInkey() {
        byte[] keyBytes= Base64.getDecoder().decode(SECRET_KEY);
        return new SecretKeySpec(keyBytes, "HmacSHA256");
    }

}
