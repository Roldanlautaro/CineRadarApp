# 🎬 CineRadar

<p align="center">
  <img src="https://github.com/user-attachments/assets/dc716fae-fed6-4fc2-b599-57111b7bc473" alt="cineradar_logo" width="400" />
</p>


**CineRadar** es una aplicación móvil moderna e intuitiva que te permite descubrir, buscar y guardar películas y series, brindándote información detallada sobre cada contenido y en qué plataforma de streaming está disponible. ¡Todo desde una sola app!

## ✨ Características principales

- 🔍 **Buscar películas y series** según tus géneros, año o plataformas favoritas.
- 📌 **Guardar contenido** para ver más tarde (Watchlist).
- ✅ **Marcar como visto** y llevar el registro en tu perfil.
- 🧠 **Recomendaciones inteligentes** según el ranking.
- 📺 Saber **dónde ver** tus contenidos favoritos (Netflix, Disney+, HBO Max, etc).
- 🌐 **Autenticación con Google** gracias a Firebase.
- ⚡️ Interfaz moderna, fluida y minimalista.

---

## 📱 Pantallas de la aplicación

| Pantalla | Descripción |
|---------|-------------|
| 🟦 Splash | Pantalla inicial con logo mientras carga la app. |
| 🔐 Login / Registro | Iniciá sesión con Google o correo/contraseña (Firebase Auth). |
| ⏳ Loader | Pantalla de carga mientras se recuperan datos de la API. |
| 🏠 Principal | Lista de contenidos populares con imágenes y descripciones (Retrofit + Glide). |
| 🧾 Detalle | Información completa de cada película o serie, con botones para guardar o marcar como visto. |
| 🔍 Búsqueda | Filtrá por título, género, plataforma o año (con Retrofit). |
| 📈 Populares | Top de películas y series más vistas o mejor rankeadas. |
| 📂 Listas | Tus contenidos guardados (watchlist) almacenados en Firebase. |
| 👤 Perfil | Información de tu cuenta, lista de contenidos vistos y opciones de gestión. |

---

## 🛠️ Tecnologías utilizadas

| Categoría | Tecnologías |
|----------|-------------|
| Lenguaje | `Kotlin` |
| Arquitectura | `MVVM`, `Repository Pattern` |
| Autenticación | `Firebase Authentication (Google Sign-In)` |
| Base de datos local | `Room` |
| Base de datos remota | `Firebase Firestore / Realtime Database` |
| Llamadas a API | `Retrofit` |
| Carga de imágenes | `Glide` |
| UI Framework | `Jetpack Compose` |
| Diseño | `Figma` |

---

## 🌐 API Rest utilizada

Utilizamos la **Streaming Availability API** para obtener información de películas y series.

---

## 🎨 Diseño y Maquetado

La interfaz fue diseñada completamente en [Figma]([https://www.figma.com](https://www.figma.com/design/icJdw9ZOm8MmPAXaXEAsk4/CineRadar?node-id=2204-215&p=f&t=FsrmjCrBvqhJJnve-0)) con foco en:

- ✅ Accesibilidad
- 🎨 Diseño minimalista
- 📱 Interfaz intuitiva para móviles

---

## 📦 Cómo clonar y correr el proyecto

```bash
git clone https://github.com/tu-usuario/cineradar.git
