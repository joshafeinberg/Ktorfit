package de.jensklingenberg.ktorfit

import org.jetbrains.kotlin.backend.common.IrElementTransformerVoidWithContext
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.backend.common.lower.parents
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.expressions.*

class ElementTransformer(
    private val pluginContext: IrPluginContext,
    private val debugLogger: DebugLogger
) : IrElementTransformerVoidWithContext() {

    override fun visitValueParameterNew(declaration: IrValueParameter): IrStatement {
        declaration.parents.forEach { parent ->
            parent.transform(CreateFuncTransformer(pluginContext,debugLogger), null)
        }
        declaration.transform(CreateFuncTransformer(pluginContext,debugLogger), null)
        return super.visitValueParameterNew(declaration)
    }

    override fun visitPropertyNew(declaration: IrProperty): IrStatement {
        declaration.transform(CreateFuncTransformer(pluginContext, debugLogger), null)
        return super.visitPropertyNew(declaration)
    }

    override fun visitCall(expression: IrCall): IrExpression {
        expression.transform(CreateFuncTransformer(pluginContext, debugLogger), null)
        return super.visitCall(expression)
    }

    override fun visitVariable(declaration: IrVariable): IrStatement {
        declaration.transform(CreateFuncTransformer(pluginContext, debugLogger), null)
        return super.visitVariable(declaration)
    }


    override fun visitFunctionExpression(expression: IrFunctionExpression): IrExpression {
        expression.transform(CreateFuncTransformer(pluginContext, debugLogger), null)
        return super.visitFunctionExpression(expression)
    }

    override fun visitBody(body: IrBody): IrBody {
        println("visitBody: $body")
        return super.visitBody(body)
    }

    override fun visitClassNew(declaration: IrClass): IrStatement {
        println("visitClassNew: $declaration")
        return super.visitClassNew(declaration)
    }

    override fun visitClassReference(expression: IrClassReference): IrExpression {
        println("visitClassReference: $expression")
        return super.visitClassReference(expression)
    }

    override fun visitAnonymousInitializerNew(declaration: IrAnonymousInitializer): IrStatement {
        println("visitAnonymousInitializerNew: $declaration")
        return super.visitAnonymousInitializerNew(declaration)
    }

    override fun visitFieldNew(declaration: IrField): IrStatement {
        println("visitFieldNew: $declaration")
        return super.visitFieldNew(declaration)
    }

    override fun visitFileNew(declaration: IrFile): IrFile {
        println("visitFileNew: $declaration")
        return super.visitFileNew(declaration)
    }

    override fun visitFunctionNew(declaration: IrFunction): IrStatement {
        println("visitFunctionNew: $declaration")
        return super.visitFunctionNew(declaration)
    }

    override fun visitScriptNew(declaration: IrScript): IrStatement {
        println("visitScriptNew: $declaration")
        return super.visitScriptNew(declaration)
    }

    override fun visitComposite(expression: IrComposite): IrExpression {
        println("visitComposite: $expression")
        return super.visitComposite(expression)
    }

    override fun visitConstructor(declaration: IrConstructor): IrStatement {
        println("visitConstructor: $declaration")
        return super.visitConstructor(declaration)
    }

    override fun visitConstructorCall(expression: IrConstructorCall): IrExpression {
        println("visitConstructorCall: $expression")
        return super.visitConstructorCall(expression)
    }

    override fun visitDeclaration(declaration: IrDeclarationBase): IrStatement {
        println("visitDeclaration: $declaration")
        return super.visitDeclaration(declaration)
    }

    override fun visitDeclarationReference(expression: IrDeclarationReference): IrExpression {
        println("visitDeclarationReference: $expression")
        return super.visitDeclarationReference(expression)
    }

    override fun visitElement(element: IrElement): IrElement {
        println("visitElement: $element")
        return super.visitElement(element)
    }

    override fun visitExpression(expression: IrExpression): IrExpression {
        println("visitExpression: $expression")
        return super.visitExpression(expression)
    }

    override fun visitExpressionBody(body: IrExpressionBody): IrBody {
        println("visitExpressionBody: $body")
        return super.visitExpressionBody(body)
    }

    override fun visitFunctionAccess(expression: IrFunctionAccessExpression): IrExpression {
        println("visitFunctionAccess: $expression")
        return super.visitFunctionAccess(expression)
    }

    override fun visitFunctionReference(expression: IrFunctionReference): IrExpression {
        println("visitFunctionReference: $expression")
        return super.visitFunctionReference(expression)
    }

    override fun visitGetClass(expression: IrGetClass): IrExpression {
        println("visitGetClass: $expression")
        return super.visitGetClass(expression)
    }

    override fun visitGetField(expression: IrGetField): IrExpression {
        print("visitGetField: $expression")
        return super.visitGetField(expression)
    }

    override fun visitBlock(expression: IrBlock): IrExpression {
        println("visitBlock: $expression")
        return super.visitBlock(expression)
    }

    override fun visitBlockBody(body: IrBlockBody): IrBody {
        println("visitBlockBody: $body")
        return super.visitBlockBody(body)
    }

    override fun visitBranch(branch: IrBranch): IrBranch {
        println("visitBranch: $branch")
        return super.visitBranch(branch)
    }

    override fun visitBreak(jump: IrBreak): IrExpression {
        println("visitBreak: $jump")
        return super.visitBreak(jump)
    }

    override fun visitBreakContinue(jump: IrBreakContinue): IrExpression {
        println("visitBreakContinue: $jump")
        return super.visitBreakContinue(jump)
    }

    override fun visitCallableReference(expression: IrCallableReference<*>): IrExpression {
        println("visitCallableReference: $expression")
        return super.visitCallableReference(expression)
    }

    override fun visitCatch(aCatch: IrCatch): IrCatch {
        println("visitCatch: $aCatch")
        return super.visitCatch(aCatch)
    }

    override fun visitConst(expression: IrConst<*>): IrExpression {
        println("visitConst: $expression")
        return super.visitConst(expression)
    }

    override fun visitConstantArray(expression: IrConstantArray): IrConstantValue {
        println("visitConstantArray: $expression")
        return super.visitConstantArray(expression)
    }

    override fun visitConstantObject(expression: IrConstantObject): IrConstantValue {
        println("visitConstantObject: $expression")
        return super.visitConstantObject(expression)
    }

    override fun visitConstantPrimitive(expression: IrConstantPrimitive): IrConstantValue {
        println("visitConstantPrimitive: $expression")
        return super.visitConstantPrimitive(expression)
    }

    override fun visitConstantValue(expression: IrConstantValue): IrConstantValue {
        println("visitConstantValue: $expression")
        return super.visitConstantValue(expression)
    }

    override fun visitContainerExpression(expression: IrContainerExpression): IrExpression {
        println("visitContainerExpression: $expression")
        return super.visitContainerExpression(expression)
    }
}