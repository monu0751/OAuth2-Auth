# Environment Variables Setup Guide

## Option 1: Using .env File (Recommended for Development)

The project includes `spring-dotenv` dependency which automatically loads variables from `.env` file.

1. The `.env` file is already created in the project root
2. Update the values in `.env` file as needed
3. Run the application - variables will be loaded automatically
4. **Note:** `.env` file is in `.gitignore` and will NOT be committed to Git

## Option 2: IntelliJ IDEA Run Configuration

If you prefer to use IntelliJ's Run Configuration:

1. Go to **Run → Edit Configurations**
2. Select your Spring Boot application configuration
3. Find the "Environment variables" field
4. Click the **folder/browse icon** (📁) next to the field
5. In the dialog, click **+** to add each variable:
   - `GOOGLE_CLIENT_ID` = `your-client-id`
   - `GOOGLE_CLIENT_SECRET` = `your-client-secret`
   - `DB_URL` = `jdbc:mysql://localhost:3306/app_db?useSSL=false&serverTimezone=UTC`
   - `DB_USERNAME` = `app_user`
   - `DB_PASSWORD` = `app_password`
6. Click **OK** to save

### Common Issues:

**Problem:** Environment variables showing as literal strings like `${DB_USERNAME}`

**Solution:** 
- Make sure you're using the dialog (folder icon) to add variables, not typing them directly
- Each variable should be on a separate line
- Don't use semicolons (`;`) between variables in IntelliJ

**Problem:** File lock on target folder during Maven clean

**Solution:** Stop the running application in IntelliJ before running Maven commands

## Option 3: System Environment Variables

You can also set these as system environment variables in Windows, but this is not recommended for sensitive data.

## Required Environment Variables:

- `GOOGLE_CLIENT_ID` - Google OAuth2 client ID
- `GOOGLE_CLIENT_SECRET` - Google OAuth2 client secret  
- `DB_URL` - Database JDBC URL
- `DB_USERNAME` - Database username
- `DB_PASSWORD` - Database password
