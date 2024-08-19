plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.jetbrains.kotlin.android)
}

android {
  namespace = "com.atenfa.pishgoo"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.atenfa.pishgoo"
    minSdk = 24
    targetSdk = 34
    versionCode = 2
    versionName = "1.0.1"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions { jvmTarget = "1.8" }

  buildFeatures { viewBinding = true }
}

dependencies {
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  implementation(libs.androidx.activity)
  implementation(libs.androidx.constraintlayout)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)

  // koin
  implementation(libs.koin.android)

  // navigation
  implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
  implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

  // lifecycle
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")

  // data store
  implementation("androidx.datastore:datastore-preferences:1.1.1")

}
