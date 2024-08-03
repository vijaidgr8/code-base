resource "local_file" "vijai" {
    filename = "/test/terraformfile1.txt"
    content = "Vijai Test 1"
}

resource "local_sensitive_file" "vijai-sensitive" {
    filename = "/test/terraformfile2.txt"
    content = "Vijai Test 2"
}