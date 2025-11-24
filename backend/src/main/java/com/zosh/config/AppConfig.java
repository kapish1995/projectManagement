private CorsConfigurationSource corsConfigurationSource() {

    CorsConfiguration cfg = new CorsConfiguration();

    cfg.setAllowedOrigins(Arrays.asList(
            "http://localhost:3000",
            "http://localhost:5173",
            "http://localhost:5174",
            "https://project-management-brown-delta.vercel.app"
    ));

    // Tumhara commented code jaisa ka taisa
    // cfg.setAllowedMethods(Collections.singletonList("*"));
    // cfg.setAllowCredentials(true);
    // cfg.setAllowedHeaders(Collections.singletonList("*"));
    // cfg.setExposedHeaders(Arrays.asList("Authorization"));
    // cfg.setMaxAge(3600L);
    // return cfg;

    cfg.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    cfg.setAllowedHeaders(Arrays.asList("*"));
    cfg.setExposedHeaders(Arrays.asList("Authorization"));
    cfg.setAllowCredentials(true);

    // *** MAJOR FIX ***
    org.springframework.web.cors.UrlBasedCorsConfigurationSource source =
            new org.springframework.web.cors.UrlBasedCorsConfigurationSource();

    source.registerCorsConfiguration("/**", cfg);

    return source;
}
