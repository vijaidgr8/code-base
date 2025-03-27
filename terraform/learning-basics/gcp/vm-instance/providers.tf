terraform {
    required_providers {
        google = {
            source  = "hashicorp/google"
        }
    }
}

provider "google" {
  project = "nth-silo-454914-q3"
  region = "us-central1"
  zone = "us-central1-a"
}