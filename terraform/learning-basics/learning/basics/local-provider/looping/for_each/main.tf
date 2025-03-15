resource "local_file" "for_Each" {
    for_each = var.file_content
    content = each.value
    filename = "${path.module}/${each.key}"
}