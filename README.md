# Clojure Quest 🧙‍♀️

Single track curriculum to learn real world Clojure & ClojureScript development. 

## What is Clojure Quest? 

> Welcome fellow traveller! You don't seem to be from around here, do ya?
>
> Oh I see, you have travelled far and wide from across the Nothern plains in
> search for the one true paren, the paren to rule them all?
> 
> Take my heed o youngling, the paths beyond here are thorny and difficult. But
> there's a secret...
> 
> Take this REPL. This is a wand of immense power; learn to use it, use it
> wisely. The power of the REPL corrupts absolutely, don't let it consume you
> lest you want to return back to the worlds of humankind.
> 
> Start your quest here to follow the paths of Clojure and find the one true
> paren!

Clojure Quest is my attempt to consolidate all learning resources under one
roof, fill in the gaps myself, and make building real world Clojure apps fun and
easy.

You can think of this as “Clojure made easy“ or “FreeCodeCamp but for Clojure &
ClojureScript” 😉

The courses will be divided into different “quests” based on difficulty levels.
So there should be something for both Clojure newbies and pros alike.

## Why?

There is a _serious_ barrier to entry in the Clojure ecosystem. Most of the clojure
programmers are already quite experienced and don't really feel the pain of beginners
or of those new to Clojure.

There is very little "content" around how to build say a full-stack production
website, or how to use a particular library. I am already trying to contribute
my bit through my YouTube channel: https://youtube.com/c/oxalorg (and I have so
much more I want to post!)

There is also a branding, marketing, and _clojure adoption_ issue at play here.
I am not going to pretend I understand these things so I would rather just link
to some conversations been happening in the community around this:

* https://clojureverse.org/t/some-thoughts-about-clojure-its-latent-potential-and-adoption/8696/16
* https://www.reddit.com/r/Clojure/comments/t53hlt/some_thoughts_about_clojure_its_latent_potential/
* Join the #growth channel in Clojurians log

Hopefully in doing this we can drastically reduce the barrier to entry into the
Clojure world.

## Can you give an example of a quest?

Yes. Quests are scenarios you need to overcome.

Example quest: You have just joined $DEFN company. On your first day you get
access to their Clojure backend code and you notice there is no `project.clj`
file. Oh noes! They are using the new fancy kid on the block - tools.deps. You
open up the `deps.edn` file but are totally confused. You go on a quest to
figure this out!

Example quest: You have just quit your job and want to start a SaaS company. You
want to make it big and get $5 trillion in VC funding. You go on a quest to
build a Clojure SaaS app with graphql / lacinia, re-frame, and XTDB.

Example quest: After lots of hard work you managed to deploy a web app in
Clojure. But every time you change a few lines of code you hear a trembling
voice echoing from deep within your mind ~~~~~“this might break”~~~~~~ but you
push the code anyways. One day you’ve had enough. You want to conquer over your
fears and sleep well at night. You decide to go on a quest to learn to write
integration tests for your web service.

Once we have a bunch of quests, there will be a larger story at play. Each quest
will have a “pre-requisite” quest to have completed, and a sequel quest to
progress in the story. This is a journey you must take to find the hidden
treasures on the Lambda Island.

## Will this be free? (Yes, for now)

The aim is to allow individuals, hobbyists, enthusiasts, and students a complete
and easy curriculum to follow. But at the same time also sell this “bootcamp”
service to companies so that they can train their new hires and juniors to get
up to speed with Clojure quickly.

Having structured courses might take away some of the "fear" for both learners
and companies and hopefully lead to more adoption.

I have no idea how I can keep this both free and paid simultaneously. If you are
a Clojure company who is finding ways to train your new hires or existing
employees, then please start a conversation with me (@oxalorg everywhere or
mitesh@miteshshah.com)

Ideally I want to find a way to monetise this in a sustainable way, if you have
ideas I would love to have a chat with you! Until I figure this out, all content
WILL BE FREE.

UPDATE: An idea here could be to get funded by companies to create “custom
quests” for them based on their tech stack.

## Will this be gamified?

YES! Thank you for asking. I was waiting for this question.

I’ve been a huge gamer all my life and I absolutely love the RPG talent / skill
trees in games like The Witcher, Borderlands, or Torchlight; and technology
trees in strategy games like Age of Empires and Civilisation.

I want to model learning in a tree format where you can choose your own path
depending on which tree you want to progress in, but not give too much choice
and have recommended paths to follow as well.

Want to become a badass frontend developer? No problem choose the “Frontend”
tree alone and nothing else!

There will also be points to earn and level up your character in the future, I
have not fletched this idea out well enough yet!

## Who are you?

I’m Mitesh (internet handle @oxalorg) and I love writing, documentation, and
have an unhealthy obsession with recording my screen all the time (I have a TB
worth of recordings never published!!).

I create Clojure[script] screencasts on my YouTube channel, do a lot of OSS
work, and was also recently funded by ClojuristsTogether for building v2 of the
clojurians log app.

Reach me at [Twitter](https://twitter.com/oxalorg) or in Clojurians slack
channel (user `@oxalorg`) or email me at mitesh@miteshshah.com

I currently work with Gaiwan.co, a Clojure consultancy, where I have had the
opportunity to work with several different real world Clojure codebases and
learn immensely from them. We are also the team behind [LambdaIsland](https://github.com/lambdaisland) 
and it’s popular OSS projects like [Kaocha](https://github.com/lambdaisland/kaocha).

If you or your company needs Clojure or ClojureScript help, feel free to start a
conversation with me & my colleagues at mitesh@gaiwan.co

---

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
