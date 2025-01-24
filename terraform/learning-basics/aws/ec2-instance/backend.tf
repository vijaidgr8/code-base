terraform {
  backend "s3" {
    bucket = "vijai-tf-statefiles"
    key    = "ec2-instance/terraform.tfstate"
    region = "us-east-1"
  }
}