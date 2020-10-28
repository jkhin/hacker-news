object Config {

    const val applicationId = "io.jk.dev.reign.hackernews"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    object FieldType {
        const val stringType = "String"
    }

    object Build {
        const val hackerNewsUrlFieldName = "HACKER_NEWS_API"
//        const val hackerNewsUrlFieldValue = "\"" + "https://hn.algolia.com/api/v1/search_by_date?query=android" + "\""
        const val hackerNewsUrlFieldValue = "\"" + "https://hn.algolia.com/api/v1/" + "\""
    }

}