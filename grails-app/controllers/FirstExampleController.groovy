
import firstexample.FirstExample
import metafunctionality.Module
import metafunctionality.ModuleOutput


class FirstExampleController {

    def start() {
        String inputID = Module.findByModuleId(params.id).inputID
        FirstExample input = FirstExample.findByModuleDataID(inputID)
        String word = input.word
        List<String> rc = input.rhymingCandidates
        rc.add(input.answer)
        //rc.toSet()
        [rc:rc, word:word, modID: params.id]
    }

    def submit() {

        List<String> valueRows = new ArrayList<String>()
        ModuleOutput output = new ModuleOutput()
        output.headers = ["word_selected", "correct_answer", "result"]
        String selected = params.candidates

        String inputID = Module.findByModuleId(params.modID).inputID
        FirstExample input = FirstExample.findByModuleDataID(inputID)

        String answer = input.answer
        String valueRow = selected + "," + answer + ","
        if (selected.equals(answer)) {
            valueRow += "correct"
        } else {
            valueRow += "incorrect"
        }
        valueRows.add(valueRow)
        output.valueRows = valueRows
        Module m = Module.findByModuleId(params.modID)
        if (m.outputIDs != null) {
            m.outputIDs.add(output.moduleDataID)
        } else {
            m.outputIDs = [output.moduleDataID]
        }
        output.type = "FirstExample"
        m.save(flush: true)
        output.save(flush: true)

        redirect(controller: "appforliteracy.FileOutput", action: "output", params: [id: output.moduleDataID])
    }

}
