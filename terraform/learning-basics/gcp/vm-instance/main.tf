terraform {
  backend "gcs" {}
}

provider "google" {
  project = "nth-silo-454914-q3"
  region = "us-central1"
  zone = "us-central1-a"
}

resource "google_compute_instance" "new-vm" {
  name         = "vm-instance-from-terraform"
  machine_type = "e2-medium"
  zone         = "us-central1-a"

  boot_disk {
    initialize_params {
      image = "projects/debian-cloud/global/images/debian-12-bookworm-v20250311"
    }
  }

  network_interface {
    network = "default"
  }
}