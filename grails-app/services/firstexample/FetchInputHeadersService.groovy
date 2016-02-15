package firstexample


class FetchInputHeadersService {

    Map<String, String> getHeaders () {
        Map<String, String> headers = new LinkedHashMap<>()
        headers.put("word", "String")
        headers.put("rhymingCandidates", "[String]")
        headers.put("answer", "String")
        return headers
    }
}
