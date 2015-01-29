package com



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

//@Transactional(readOnly = true)
class ExceptionRefController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ExceptionRef.list(params), model:[exceptionRefInstanceCount: ExceptionRef.count()]
    }

    def show(ExceptionRef exceptionRefInstance) {
def value=params.caseId
println "++++++++++++" + value
       
        respond exceptionRefInstance
    }

    def create() {
        respond new ExceptionRef(params)
    }

    @Transactional
    def save(ExceptionRef exceptionRefInstance) {
        if (exceptionRefInstance == null) {
            notFound()
            return
        }

        if (exceptionRefInstance.hasErrors()) {
            respond exceptionRefInstance.errors, view:'create'
            return
        }

        exceptionRefInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'exceptionRef.label', default: 'ExceptionRef'), exceptionRefInstance.id])
                redirect exceptionRefInstance
            }
            '*' { respond exceptionRefInstance, [status: CREATED] }
        }
    }

    def edit(ExceptionRef exceptionRefInstance,Integer caseId) {
//HashMap<String,Object> hm=new HashMap<String,Object>()
//hm.put("exceptionRefInstance",exceptionRefInstance)
//hm.put("case no",caseId)
def value=params.caseId
println "++++++++++++" + value
         respond exceptionRefInstance
    }

    //@Transactional
    def update(ExceptionRef exceptionRefInstance,Integer caseId) {
//def value=params.caseId
//println "++++++++++++" + value
        if (exceptionRefInstance == null) {
            notFound()
            return
        }
           
 

        if (exceptionRefInstance.hasErrors()) {
            respond exceptionRefInstance.errors, view:'edit'
            return
        }

        exceptionRefInstance.save flush:true
def value=caseId
println "++++++++++++" + value

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ExceptionRef.label', default: 'ExceptionRef'), exceptionRefInstance.id])
                redirect exceptionRefInstance
            }
            '*'{ respond exceptionRefInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ExceptionRef exceptionRefInstance) {

        if (exceptionRefInstance == null) {
            notFound()
            return
        }

        exceptionRefInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ExceptionRef.label', default: 'ExceptionRef'), exceptionRefInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'exceptionRef.label', default: 'ExceptionRef'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
