
import firstexample.FirstExample
import metafunctionality.Module
import metafunctionality.ModuleOutput

class FirstExampleController {

    def start() {
        String inputID = Module.findByModuleId(params.id).inputID
        FirstExample input = FirstExample.findByModuleDataID(inputID)

        String[] words = input.words
        [lsOut:words, modID: params.id]
    }

    def submit() {
        String[] words = params.words
        List<String> valueRows = new ArrayList<String>()
        ModuleOutput output = new ModuleOutput()
        output.headers = ["word", "length"]
        for (int i = 0; i < words.length; i++) {
            String line = words[i] + "," + words[i].length()
            valueRows.add(line)
        }
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
