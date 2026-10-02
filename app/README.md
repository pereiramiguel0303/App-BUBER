# Buber (Android)

Fase 1: esqueleto Compose + MapLibre (OSM) centrado em São Leopoldo, tema Uber-like e navegação inferior.

## Como aplicar no seu projeto
1. Copie `gradle/libs.versions.toml`, `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, `app/` e `.gitignore` para a raiz do repositório (substituindo os gerados pelo Android Studio). Não sobrescreva `gradle/wrapper/`.
2. Se o seu `applicationId` não for `com.buber.app`, renomeie o pacote (botão direito no pacote > Refactor > Rename) e ajuste `namespace`/`applicationId` em `app/build.gradle.kts`.
3. File > Sync Project with Gradle Files e execute em um emulador/dispositivo.
