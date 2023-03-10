package example.micronaut;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext
import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.services.lambda.runtime.Context
import io.micronaut.function.aws.proxy.MicronautLambdaHandler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FunctionRequestHandlerTest {

    @Test
    fun testFunctionRequestHandler() {
        val handler = MicronautLambdaHandler()
        val lambdaContext: Context = MockLambdaContext()
        val request = AwsProxyRequest()
        request.httpMethod = "GET"
        request.path = "/"
        var  response = handler.handleRequest(request, lambdaContext)
        assertEquals(200, response.statusCode)
        assertEquals("{\"message\":\"Hello World\"}", response.body)
        handler.applicationContext.close()
    }
}
