export const oktaConfig = {
    clientId: "0oalr73k0sZQ7G5OL5d7",
    issuer: "https://dev-64381758.okta.com/oauth2/default",
    redirectUri: "https://localhost:3000/login/callback",
    scopes: ["openid","profile","email"],
    pkce: true,
    disableHttpCheck: true,
    useClassicEngine: true
}