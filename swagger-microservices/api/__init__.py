from http.client import HTTPResponse

items = {
    0: {"name": "First item"}
}


def search() :
    return items

def post(id):
    return id