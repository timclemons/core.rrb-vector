(defproject org.clojure/core.rrb-vector "0.0.11-SNAPSHOT"
  :description "RRB-Trees for Clojure(Script) -- see Bagwell & Rompf"
  :url "https://github.com/clojure/core.rrb-vector"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.2.0"
  :parent [org.clojure/pom.contrib "0.1.2"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [prismatic/cljs-test "0.0.6"]]
  :source-paths ["src/main/clojure"
                 "src/main/cljs"]
  :test-paths ["src/test/clojure"]
  :global-vars {*warn-on-reflection* true}
  :jvm-opts ^:replace []
  :plugins [[lein-cljsbuild "1.0.2"]]
  :hooks [leiningen.cljsbuild]
  :profiles {:dev {:test-paths ["src/test_local/clojure"]
                   :dependencies [[collection-check "0.1.1"]
                                  [com.cemerick/double-check "0.5.7-SNAPSHOT"]]}}
  :cljsbuild {:builds {:test {:source-paths ["src/main/cljs"
                                             "src/test/cljs"]
                              :compiler {:optimizations :simple
                                         :pretty-print true
                                         :output-to "out/unit-test.js"}}}
              :test-commands {"unit" ["/usr/local/bin/phantomjs"
                                      "out/unit-test.js"
                                      "resources/private/html/unit-test.html"]}})
