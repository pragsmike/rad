(ns rad.core-test
  (:require [clojure.test :refer :all]
            [rad.core :refer :all]))

(defn sample-grc [name]
  (clojure.xml/parse "test/two.grc")
  )

(deftest test-grc-meta
  (let [grc (sample-grc "two")]
    (is (= {:timestamp "Sat Aug 17 11:42:56 2019"}
           (grc-meta grc)))
    (is (= 4 (count (grc-blocks grc))))
    (is (= [["options" "top_block" "(8, 8)"]
            ["variable" "samp_rate" "(8, 160)"]
            ["osmosdr_source" "osmosdr_source_0" "(496, 380)"]
            ["qtgui_time_sink_x" "qtgui_time_sink_x_0" "(944, 436)"]]
           (map (juxt :key :id :_coordinate) (grc-blocks grc))))
    #_(is (= nil (grc-blocks grc)))
    ))
