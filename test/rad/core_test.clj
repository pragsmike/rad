(ns rad.core-test
  (:require [clojure.test :refer :all]
            [rad.core :refer :all]))

(defn sample-grc [name]
  (clojure.xml/parse "test/two.grc")
  )

(deftest test-grc-meta
  (let [grc (sample-grc "two")]
    (is (= {:timestamp ["Sat Aug 17 11:42:56 2019"]}
           (grc-meta grc)))
    #_(is (= nil (grc-blocks grc)))
    ))
