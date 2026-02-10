# Environment Setup Guide

This guide explains how to configure environment variables for the OAuth2-Auth application.

## Option 1: Using application-local.yaml (Recommended for Development)

1. Copy `.env.example` to create your local configuration:
   ```
   Copy the values from .env.example
   ```

2. Create `src/main/resources/application-local.yaml` with your actual credentials:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/app_db?useSSL=false&serverTimezone=UTC
       username: app_user
       password: app_password
     security:
       oauth2:
         client:
           registration:
             google:
               client-id: your-actual-client-id
               client-secret: your-actual-client-secret
               scope:
                 - email
                 - profile
   ```

3. Run the application with the `local` profile:
   ```
   mvn spring-boot:run -Dspring-boot.run.profiles=local
   ```

   Or in IntelliJ IDEA:
   - Run → Edit Configurations
   - Add `local` to "Active profiles"

## Option 2: Using .env file

1. Copy `.env.example` to `.env`:
   ```
   cp .env.example .env
   ```

2. Edit `.env` with your actual credentials:
   ```properties
   GOOGLE_CLIENT_ID=your-actual-client-id
   GOOGLE_CLIENT_SECRET=your-actual-client-secret
   DB_URL=jdbc:mysql://localhost:3306/app_db?useSSL=false&serverTimezone=UTC
   DB_USERNAME=app_user
   DB_PASSWORD=app_password
   ```

3. The `spring-dotenv` dependency will automatically load these variables.

## Option 3: System Environment Variables (Production)

Set environment variables in your system or container:

**Windows (PowerShell):**
```powershell
$env:GOOGLE_CLIENT_ID="your-client-id"
$env:GOOGLE_CLIENT_SECRET="your-client-secret"
$env:DB_URL="jdbc:mysql://localhost:3306/app_db?useSSL=false&serverTimezone=UTC"
$env:DB_USERNAME="app_user"
$env:DB_PASSWORD="app_password"
```

**Linux/Mac:**
```bash
export GOOGLE_CLIENT_ID="your-client-id"
export GOOGLE_CLIENT_SECRET="your-client-secret"
export DB_URL="jdbc:mysql://localhost:3306/app_db?useSSL=false&serverTimezone=UTC"
export DB_USERNAME="app_user"
export DB_PASSWORD="app_password"
```

## IntelliJ IDEA Configuration

1. Go to **Run** → **Edit Configurations**
2. Select your Spring Boot run configuration
3. In **Environment Variables**, add:
   ```
   GOOGLE_CLIENT_ID=your-client-id;GOOGLE_CLIENT_SECRET=your-client-secret;DB_URL=jdbc:mysql://localhost:3306/app_db?useSSL=false&serverTimezone=UTC;DB_USERNAME=app_user;DB_PASSWORD=app_password
   ```

## Required Environment Variables

| Variable | Description | Example |
|----------|-------------|---------|
| `GOOGLE_CLIENT_ID` | Google OAuth2 Client ID | `414455648691-xxx.apps.googleusercontent.com` |
| `GOOGLE_CLIENT_SECRET` | Google OAuth2 Client Secret | `GOCSPX-xxxxxx` |
| `DB_URL` | MySQL Database URL | `jdbc:mysql://localhost:3306/app_db?useSSL=false&serverTimezone=UTC` |
| `DB_USERNAME` | Database Username | `app_user` |
| `DB_PASSWORD` | Database Password | `app_password` |

## Security Notes

- **Never commit** `.env` or `application-local.yaml` files to version control
- These files are already in `.gitignore`
- Use `.env.example` as a template for team members
- In production, use secure secret management (e.g., AWS Secrets Manager, HashiCorp Vault)
