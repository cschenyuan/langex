	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 10
	.globl	_combine1
	.align	4, 0x90
_combine1:                              ## @combine1
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp0:
	.cfi_def_cfa_offset 16
Ltmp1:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp2:
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r12
	pushq	%rbx
	subq	$16, %rsp
Ltmp3:
	.cfi_offset %rbx, -48
Ltmp4:
	.cfi_offset %r12, -40
Ltmp5:
	.cfi_offset %r14, -32
Ltmp6:
	.cfi_offset %r15, -24
	movq	%rsi, %r14
	movq	%rdi, %r15
	movl	$0, (%r14)
                                        ## kill: RDI<def> R15<kill>
	callq	_vec_length
	xorl	%ebx, %ebx
	testq	%rax, %rax
	jle	LBB0_3
## BB#1:
	leaq	-36(%rbp), %r12
	.align	4, 0x90
LBB0_2:                                 ## %.lr.ph
                                        ## =>This Inner Loop Header: Depth=1
	movq	%r15, %rdi
	movq	%rbx, %rsi
	movq	%r12, %rdx
	callq	_get_vec_element
	movl	-36(%rbp), %eax
	addl	%eax, (%r14)
	incq	%rbx
	movq	%r15, %rdi
	callq	_vec_length
	cmpq	%rax, %rbx
	jl	LBB0_2
LBB0_3:                                 ## %._crit_edge
	addq	$16, %rsp
	popq	%rbx
	popq	%r12
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc

	.globl	_combine2
	.align	4, 0x90
_combine2:                              ## @combine2
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp7:
	.cfi_def_cfa_offset 16
Ltmp8:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp9:
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	pushq	%rax
Ltmp10:
	.cfi_offset %rbx, -56
Ltmp11:
	.cfi_offset %r12, -48
Ltmp12:
	.cfi_offset %r13, -40
Ltmp13:
	.cfi_offset %r14, -32
Ltmp14:
	.cfi_offset %r15, -24
	movq	%rsi, %r14
	movq	%rdi, %r15
                                        ## kill: RDI<def> R15<kill>
	callq	_vec_length
	movq	%rax, %r12
	movl	$0, (%r14)
	xorl	%ebx, %ebx
	testq	%r12, %r12
	jle	LBB1_3
## BB#1:
	leaq	-44(%rbp), %r13
	.align	4, 0x90
LBB1_2:                                 ## =>This Inner Loop Header: Depth=1
	movq	%r15, %rdi
	movq	%rbx, %rsi
	movq	%r13, %rdx
	callq	_get_vec_element
	movl	-44(%rbp), %eax
	addl	%eax, (%r14)
	incq	%rbx
	cmpq	%rbx, %r12
	jne	LBB1_2
LBB1_3:                                 ## %._crit_edge
	addq	$8, %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc

	.globl	_combine3
	.align	4, 0x90
_combine3:                              ## @combine3
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp15:
	.cfi_def_cfa_offset 16
Ltmp16:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp17:
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%rbx
	pushq	%rax
Ltmp18:
	.cfi_offset %rbx, -40
Ltmp19:
	.cfi_offset %r14, -32
Ltmp20:
	.cfi_offset %r15, -24
	movq	%rsi, %r14
	movq	%rdi, %r15
                                        ## kill: RDI<def> R15<kill>
	callq	_vec_length
	movq	%rax, %rbx
	movq	%r15, %rdi
	callq	_get_vec_start
	movl	$0, (%r14)
	testq	%rbx, %rbx
	jle	LBB2_2
	.align	4, 0x90
LBB2_1:                                 ## =>This Inner Loop Header: Depth=1
	movl	(%rax), %ecx
	addl	%ecx, (%r14)
	addq	$4, %rax
	decq	%rbx
	jne	LBB2_1
LBB2_2:                                 ## %._crit_edge
	addq	$8, %rsp
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc


.subsections_via_symbols
