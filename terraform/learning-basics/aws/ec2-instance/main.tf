resource "aws_instance" "sample-instance-from-jenkins" {
  ami           = "ami-053b0d53c279acc90"
  instance_type = "t2.micro"
  
  tags = {
    Name = "Gift from Jenkins"
  }
}