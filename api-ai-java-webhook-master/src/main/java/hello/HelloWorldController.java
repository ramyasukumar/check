package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/webhook")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.POST)
public @ResponseBody WebhookResponse webhook(@RequestBody WebhookRequest webhookRequest){

        String percentage =webhookRequest.getResolvedQuery();

        int value = Integer.parseInt(percentage.replaceAll("[^0-9]", ""));

        String speech ;
      //  String display_text;
        if (value >75)
        {
         speech="congrats ! you are eligible";
            //display_text="congrats ! you are eligible";
        }
        else
        {
            speech ="sorry ! you are not eligible you can try another course";
           // display_text="sorry ! you are not eligible you can try another course";
        }

       // System.out.println(obj);

        return new WebhookResponse(speech, "text");   
    }
}
