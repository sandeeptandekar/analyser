package com



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LogExceptionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LogException.list(params), model:[logExceptionInstanceCount: LogException.count()]
    }

    def show(LogException logExceptionInstance) {
        respond logExceptionInstance
    }

    def create() {
        respond new LogException(params)
    }

    @Transactional
    def save(LogException logExceptionInstance) {
        if (logExceptionInstance == null) {
            notFound()
            return
        }

        if (logExceptionInstance.hasErrors()) {
            respond logExceptionInstance.errors, view:'create'
            return
        }

        logExceptionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'logException.label', default: 'LogException'), logExceptionInstance.id])
                redirect logExceptionInstance
            }
            '*' { respond logExceptionInstance, [status: CREATED] }
        }
    }

    def edit(LogException logExceptionInstance) {
        respond logExceptionInstance
    }

    @Transactional
    def update(LogException logExceptionInstance) {
        if (logExceptionInstance == null) {
            notFound()
            return
        }

        if (logExceptionInstance.hasErrors()) {
            respond logExceptionInstance.errors, view:'edit'
            return
        }

        logExceptionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LogException.label', default: 'LogException'), logExceptionInstance.id])
                redirect logExceptionInstance
            }
            '*'{ respond logExceptionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LogException logExceptionInstance) {

        if (logExceptionInstance == null) {
            notFound()
            return
        }

        logExceptionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LogException.label', default: 'LogException'), logExceptionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'logException.label', default: 'LogException'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
