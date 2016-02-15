package firstexample

import metafunctionality.ModuleInput

class FirstExample extends ModuleInput {
    String word
    String answer
    static hasMany = [rhymingCandidates:String]
    List rhymingCandidates
}
