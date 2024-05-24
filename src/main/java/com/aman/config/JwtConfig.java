package com.aman.config;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    private String secret="wyGWtEyqD8W5efLttumxf+vMHvN9FKDlszdx0Renz08FOiWuYJkDSf3GJ5PA7yT1z/e79XEaLUfbATR1lWnqmVIgSpGTAlOU31y5B7ua4htLMWScHnwB0Q43nQ+3hOAI1Kg8VSTKLtP2e6YOSUvBW1df0xQ4b8sBETRfKBDrvNZ9Wbcx1HQuGiz/H1Ln0vIEoATBCxbAcP49APDzsCU5cJ5CcmQPlFwrcd/X0F7e4PAgII16cu9s+MfGiZV3wLHixDgvDqdpIeheusdhgiSBwTcp8cwVEApRwn6Uyce2CF5py54ZjCbLraNv9uEQUCwinJvkTrr4tBQarFxA75L//gTwKbXCcWwj92PZj3Ngopo=";

    private long expiration=  1000 * 60 * 24;

    // Getters
    public String getSecret() {
        return secret;
    }

    public long getExpiration() {
        return expiration;
    }
}

