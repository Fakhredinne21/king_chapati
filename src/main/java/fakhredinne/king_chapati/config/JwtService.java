package fakhredinne.king_chapati.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.eclipse.angus.mail.util.BASE64DecoderStream;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Signature;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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



    //Generate token with claims
    public String generateToken(
            UserDetails userDetails
    ){
        return generateToken(new HashMap<>(),userDetails);
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()))&& !isTokenExpired((token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    //Extract Expiration Date
    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }


    //Generate token with claims
    public String generateToken(
            Map<String,Object> extraClaims,
            UserDetails userDetails
            ){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+100*60*24))
                .signWith(SignatureAlgorithm.HS256,getSignInkey()).compact();


    }



    //Extract All Claims
  private Claims extractAllClaims(String token){
        //Extract all claims of that specific token
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
