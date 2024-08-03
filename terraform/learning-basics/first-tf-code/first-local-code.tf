resource "local_file" "vijai" {
    filename = "/mnt/d/Learning/Playgrounds/terraform_playground/first-tf-code/result.txt"
    content = "Vijai Test 1"
}

resource "local_sensitive_file" "vijai-sensitive" {
    filename = "/mnt/d/Learning/Playgrounds/terraform_playground/first-tf-code/result1.txt"
    content = "Vijai Test 2"
}