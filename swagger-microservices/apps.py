import connexion
from connexion.resolver import RestyResolver

if __name__ == '__main__':
    app = connexion.App(__name__,specification_dir='swagger/')
    app.add_api('my_super_app.yaml', resolver=RestyResolver('api'))
   # FlaskInjector(app=app.app, modules=[configure])
    app.run(host="0.0.0.0", port=9090)