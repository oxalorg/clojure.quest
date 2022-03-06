.PHONY: repl setup build build-action test-static-build

repl:
	clj -A:dev

setup:
	npm install

build:
	rm -rf _site
	npx shadow-cljs release main
	clojure -X:freeze
	cp -r resources/public/* _site/
	cp resources/.nojekyll _site/
	cp CNAME _site/

build-action: setup build

test-static-build:
	cd _site && python3 -m http.server 8080 --bind 127.0.0.1
	echo "Open localhost:8080"
