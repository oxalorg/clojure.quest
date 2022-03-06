# Clojure Quest

## Development

Ensure that you have installed the NPM packages at least once:

```
npm install
```

### Emacs

With Emacs, `cider-jack-in-clj&cljs` should get you up and running.

Using this command, two REPL’s should open: one for ClojureScript and
one for Clojure. At the Clojure dedicated REPL, in the `user`
namespace (the default), run `(go)` to serve the project locally on
http://localhost:7070

After that, either navigate to that address manually or evaluate
`(browse)` in the same namespace (`user`) to open the page in your
default browser.

## Build and deploy

To build the static version of the site, run:

```
bin/dev build
```

GitHub actions will automatically deploy the site using reitit-jaatya

## Deploy testing

Warning: this workflow is not working.

To test GitHub action deployment locally, run the following command:

```
docker build -t clojure-quest .github/actions 
docker run -v $(pwd):/app -it clojure-quest:latest
```
