plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "dailytaskmanager" // Ajuste para um namespace consistente
    compileSdk = 34

    defaultConfig {
        applicationId = "dailytaskmanager" // Consistência com o namespace
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1" // Verifique se é a versão mais recente
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}" // Exclui metadados de bibliotecas
        }
    }
}

dependencies {
    // Bibliotecas do AndroidX
    implementation("androidx.appcompat:appcompat:1.7.0") // Última versão estável
    implementation("androidx.core:core-ktx:1.13.1") // Última versão estável
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2") // Última versão estável
    implementation("androidx.activity:activity-compose:1.6.1") // Última versão estável
    implementation(platform("androidx.compose.bom:2024.1.0")) // Controle de versão do Compose
    implementation("androidx.compose.ui:ui:2024.1.0") // Última versão do Compose
    implementation("androidx.compose.ui:ui-tooling-preview:2024.1.0") // Ferramentas de visualização do Compose
    implementation("androidx.material3:material3:1.1.0") // Material 3

    // Dependência de teste da Mediação
    // implementation(libs.mediation.test.suite) // Comente se não for necessária

    // Dependências para testes
    testImplementation("junit:junit:4.13.2") // Testes unitários
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // Testes de UI
    androidTestImplementation("androidx.espresso:espresso-core:3.5.1") // Espresso para testes de UI
    androidTestImplementation(platform("androidx.compose.bom:2024.1.0")) // Controle de versão do Compose para testes
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:2024.1.0") // Testes do Compose
    debugImplementation("androidx.compose.ui:ui-tooling:2024.1.0") // Ferramentas de depuração do Compose
    debugImplementation("androidx.compose.ui:ui-test-manifest:2024.1.0") // Manifesto de teste do Compose
}
