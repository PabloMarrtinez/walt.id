package id.walt.cli


import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.choice
import com.github.ajalt.clikt.parameters.types.enum
import com.github.ajalt.clikt.parameters.types.path
import id.walt.common.readWhenContent
import id.walt.crypto.KeyAlgorithm
import id.walt.services.key.KeyFormat
import id.walt.services.key.KeyService
import id.walt.services.keystore.KeyType
import id.walt.services.ecosystems.fabric.VDR
import java.nio.file.Path 
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.github.ajalt.clikt.parameters.types.file


class FabricComand : CliktCommand(
    name="fabric", help="""
    
    Carries out communication with hyperledger fabric for registration and DID request.

    """
){

    override fun run() {
    
    }
}


//Upload DID docuemnts.
class CreateComand : CliktCommand(
    name="create", help="""
    
    Create create new DID Document.

    """
){
    val key: String by option("-k", "--key", help = "KEY to be onboarded").required()
    val did: String by option("-d", "--did", help = "DID to be onboarded").required()

    override fun run() {
        echo("Uploading new DID documents...")
        VDR.initialize()
        VDR.setValue(key,did)    
    }
}

//Get DID docuemnts.
class resolveCommand : CliktCommand(
    name="resolve", help="""
    
    makes DID resolution via FABRIC.

    """
){
    val key: String by option("-k", "--key", help = "KEY to be onboarded").required()
    override fun run() {
        echo("Sending a did resolution to the hyperledger fabric blockchain...")
        VDR.initialize()
        VDR.getValue(key)    
    }
}

