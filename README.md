# efp-clojure-text-sharing

generated using Luminus version "2.9.12.62"

## Todo

- Creating a new snippet by editing an existing snippet

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

For local development create `dev-config.edn` with the following content:

```edn
{:dev true
 :port 3000
 ;; when :nrepl-port is set the application starts the nREPL server on load
 :nrepl-port 7000
 :database-url "mongodb://..."
}

```

To start a web server for the application, run:

    lein run 
