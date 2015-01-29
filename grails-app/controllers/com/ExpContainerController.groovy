package com



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ExpContainerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ExpContainer.list(params), model:[expContainerInstanceCount: ExpContainer.count()]
    }

    def show(ExpContainer expContainerInstance) {
        respond expContainerInstance
    }

    def create() {
        respond new ExpContainer(params)
    }

    @Transactional
    def save(ExpContainer expContainerInstance) {
        if (expContainerInstance == null) {
            notFound()
            return
        }

        if (expContainerInstance.hasErrors()) {
            respond expContainerInstance.errors, view:'create'
            return
        }

        expContainerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'expContainer.label', default: 'ExpContainer'), expContainerInstance.id])
                redirect expContainerInstance
            }
            '*' { respond expContainerInstance, [status: CREATED] }
        }
    }

    def edit(ExpContainer expContainerInstance) {
        respond expContainerInstance
    }

    @Transactional
    def update(ExpContainer expContainerInstance) {
        if (expContainerInstance == null) {
            notFound()
            return
        }

        if (expContainerInstance.hasErrors()) {
            respond expContainerInstance.errors, view:'edit'
            return
        }

        expContainerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ExpContainer.label', default: 'ExpContainer'), expContainerInstance.id])
                redirect expContainerInstance
            }
            '*'{ respond expContainerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ExpContainer expContainerInstance) {

        if (expContainerInstance == null) {
            notFound()
            return
        }

        expContainerInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ExpContainer.label', default: 'ExpContainer'), expContainerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'expContainer.label', default: 'ExpContainer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
